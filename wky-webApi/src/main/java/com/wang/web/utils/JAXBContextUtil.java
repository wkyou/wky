package com.wang.web.utils;

import com.wang.web.pojo.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * @Author WangKanYou
 * @Date 2022/8/30 15:14
 * @描述:
 */
public class JAXBContextUtil {
    private static String converToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            //指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            //设置编码
            marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
            //是否生成头部信息 true不生成 flase 生成
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj,writer);
            result =writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("小明");
        user.setAge(18);
        user.setSex("男");
        user.setEncoding("UTF-8");
        User.CourseInfo info1 = new User.CourseInfo();
        info1.setSuject("语文");
        info1.setScore(92);
        User.CourseInfo info2 = new User.CourseInfo();
        info2.setSuject("数学");
        info2.setScore(98);
        ArrayList<User.CourseInfo> courseInfos = new ArrayList<>();
        courseInfos.add(info1);
        courseInfos.add(info2);
        user.setCourseInfos(courseInfos);
        System.out.println(converToXml(user, "UTF-8"));
    }
}
