package com.wang.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 商品库存表
 * </p>
 *
 * @author mybatis-plus自动生成
 * @since 2023-03-20
 */
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String name;

    private Integer stock;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    private String updateBy;

    private String createBy;

    /**
     * 0正常，1删除
     */
    private String delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Stock{" +
        "id=" + id +
        ", name=" + name +
        ", stock=" + stock +
        ", remarks=" + remarks +
        ", updateDate=" + updateDate +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", createBy=" + createBy +
        ", delFlag=" + delFlag +
        "}";
    }
}
