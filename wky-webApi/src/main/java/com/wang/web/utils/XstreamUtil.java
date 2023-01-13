package com.wang.web.utils;

import com.thoughtworks.xstream.XStream;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author WangKanYou
 * @Date 2022/8/30 17:44
 * @描述:
 */
public class XstreamUtil {
    /**
     * 把xml转 对象
     *
     * @param clazz
     * @param xml
     * @return
     */
    public static <T> T toBean(Class<T> clazz, String xml,String rootTag) {
        T xmlObject;
        XStream xstream = new XStream();
        xstream.alias(rootTag, clazz);
        xstream.autodetectAnnotations(true);
        xstream.ignoreUnknownElements();
        xmlObject = (T) xstream.fromXML(xml);
        return xmlObject;
    }

    // 做缓存
    private static final ConcurrentHashMap xStreamMap = new ConcurrentHashMap<String, XStream>();
    /**
     * 将XML转为对象
     * @param xml
     * @param child 节点实体类，多个实体，都传过来
     * @return
     */
    public static Object simpleXmlToObject(String xml, Object rootObject, Object... child) {
        Object reobj = null;
        String xStreamKey = rootObject.getClass().getName();
        if(Objects.isNull(xStreamMap.get(xStreamKey))){
            XStream xStream = new XStream();
            xStreamMap.put(xStreamKey, xStream);
        }
        XStream xStream = (XStream)xStreamMap.get(xStreamKey);
        // 忽略未知属性
        xStream.ignoreUnknownElements();
        // 自动检测注解
        xStream.autodetectAnnotations(true);
        // 当前类添加到XStream白名单，XStream1.4.18版本默认开启了白名单
        xStream.allowTypes(new Class[]{rootObject.getClass()});
        // 起别名，默认使用实体的属性名做别名
        xStream.alias(rootObject.getClass().getSimpleName(), rootObject.getClass());

        // 如果根目录下有子节点，需要设置白名单及别名
        for (Object obj : child) {
            xStream.allowTypes(new Class[]{obj.getClass()});
            xStream.alias(obj.getClass().getSimpleName(), obj.getClass());
        }
        reobj = xStream.fromXML(xml);
        return reobj;
    }


    /**
     * bean -> xml
     * @param rootObe 要转换的对象
     * @param child 子节点
     * @return
     */
    public static String simpleObjectToXml(Object rootObe, Object... child) {
        Object reobj = null;
        String xStreamKey = rootObe.getClass().getName();
        if(Objects.isNull(xStreamMap.get(xStreamKey))){
            XStream xStream = new XStream();
            xStreamMap.put(xStreamKey, xStream);
        }
        XStream xStream = (XStream)xStreamMap.get(xStreamKey);
        // 忽略未知属性
        xStream.ignoreUnknownElements();
        // 自动检测注解
        xStream.autodetectAnnotations(true);
        // 当前类添加到XStream白名单，XStream1.4.18版本默认开启了白名单
        xStream.allowTypes(new Class[]{rootObe.getClass()});
        // 起别名，默认使用实体的属性名做别名
        xStream.alias(rootObe.getClass().getSimpleName(), rootObe.getClass());

        // 如果根目录下有子节点，需要设置白名单及别名
        for (Object obj : child) {
            xStream.allowTypes(new Class[]{obj.getClass()});
            xStream.alias(obj.getClass().getSimpleName(), obj.getClass());
        }

        // StringBuffer xmlchild = new StringBuffer();

        String xml = xStream.toXML(rootObe);
        return xml;
    }
}