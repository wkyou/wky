package com.wang.web.pojo.wxbean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 9:57
 * @描述:
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class WxServiceMsgDto {

    @XmlElement(name = "Event")
    private String event;

    @XmlElement(name = "Content")
    private String content;

    @XmlElement(name = "MsgType")
    private String msgType;

    @XmlElement(name = "ToUserName")
    private String toUserName;


    /**
     * fromUserName为关注人的openId
     **/

    @XmlElement(name = "FromUserName")
    private String fromUserName;

    @XmlElement(name="CreateTime")
    private String createTime;
}
