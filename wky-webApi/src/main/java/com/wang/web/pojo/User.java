package com.wang.web.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 11:41
 * @描述:
 */
@Data
@XmlRootElement(name = "request") //用于类级别的注解，对应xml的跟元素。通过name属性定义这个根节点的名称。
/**
 * PROPERTY：自动绑定getter/setter方法的属性。
 * FIELD：自动绑定非静态、非瞬态字段。
 * PUBLIC_MEMBER(默认)：相当于PROPERTY+FIELD。
 * NONE：都不绑定。
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement(name="nane")
    private String userName;
    private Integer age;
    private String sex;
    private Date time;
    @XmlAttribute(name = "encoding")    //用于把java对象的属性映射为xml的属性,并可通过name属性为生成的xml属性指定别名。
    private String encoding;
    @XmlElementWrapper(name = "resultData") //为数组或集合增加定义一个父节点。通过name属性定义这个父节点的名称。
    private List<CourseInfo> courseInfos;
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CourseInfo{
        private String suject;
        @XmlElement(name="chengJi")
        private Integer score;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", time=" + format.format(time) +
                ", encoding='" + encoding + '\'' +
                ", courseInfos=" + courseInfos +
                '}';
    }

    public String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(time);
    }
}
