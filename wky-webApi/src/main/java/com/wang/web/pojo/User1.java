package com.wang.web.pojo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 11:41
 * @描述:
 */
@Data
public class User1 {
    @XStreamAlias("name")
    private String userName;
    private Integer age;
    private String sex;
    @XStreamAlias("encoding")
    @XStreamAsAttribute
    private String encoding;
    @XStreamAlias("resultData")
    private List<CourseInfo> courseInfos;
    @Data
    @XStreamAlias("courseInfos")
    public static class CourseInfo{
        private String suject;
        @XStreamAlias("chengJi")
        private Integer score;
    }

    public static void main(String[] args) {
        String str="<request encoding=\"UTF-8\"><name>小明</name><age>18</age><sex>男</sex><resultData><courseInfos><suject>语文</suject><chengJi>92</chengJi></courseInfos><courseInfos><suject>数学</suject><chengJi>98</chengJi></courseInfos></resultData></request>";
        User1 request = toBean(User1.class, str, "request");
        System.out.println(request);
    }


    private static <T> T toBean(Class<T> clazz, String xml,String rootTag) {
        T xmlObject;
        XStream xstream = new XStream();
        xstream.alias(rootTag, clazz);
        xstream.autodetectAnnotations(true);
        xstream.ignoreUnknownElements();
        xmlObject = (T) xstream.fromXML(xml);
        return xmlObject;
    }
}
