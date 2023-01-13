package com.wang.dao.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TWxFwhXcxPatient implements Serializable {
    private Integer id;

    private String unionid;

    @ApiModelProperty(value = "服务号的openid")
    private String fwhOpenid;

    @ApiModelProperty(value = "是否关注服务号 0：已取消关注 1：关注")
    private Integer fwhSubscribe;

    @ApiModelProperty(value = "小程序的openID")
    private String xcxOpenid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getFwhOpenid() {
        return fwhOpenid;
    }

    public void setFwhOpenid(String fwhOpenid) {
        this.fwhOpenid = fwhOpenid;
    }

    public Integer getFwhSubscribe() {
        return fwhSubscribe;
    }

    public void setFwhSubscribe(Integer fwhSubscribe) {
        this.fwhSubscribe = fwhSubscribe;
    }

    public String getXcxOpenid() {
        return xcxOpenid;
    }

    public void setXcxOpenid(String xcxOpenid) {
        this.xcxOpenid = xcxOpenid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", unionid=").append(unionid);
        sb.append(", fwhOpenid=").append(fwhOpenid);
        sb.append(", fwhSubscribe=").append(fwhSubscribe);
        sb.append(", xcxOpenid=").append(xcxOpenid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}