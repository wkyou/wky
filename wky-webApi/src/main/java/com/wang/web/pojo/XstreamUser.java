package com.wang.web.pojo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 11:41
 * @描述:
 */
@Data
public class XstreamUser {
    private String userName;
    private Integer age;
    private String sex;
    private String encoding;
    private List<CourseInfo> courseInfos;
    @Data
    public static class CourseInfo{
        private String suject;
        private Integer score;
    }

}
