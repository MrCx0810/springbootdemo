package com.ch.entity;

/**
 * Created by IntelliJ IDEA.
 * @Description: 权限实体
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:03
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;
import java.util.List;

public class Power implements Serializable{

    private Integer id;
    /**
     *上级ID
     */
    private Integer pid;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型 0.菜单 1.功能
     */
    private Integer type;
    /**
     * 状态 0.正常  1.禁用
     */
    private Integer state;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 地址
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 导航栏控制选中
     */
    private String active;
    /**
     *下拉打开标志
     */
    private String content;
    /**
     * 是否打勾标志
     */
    private Integer isLay;
    private List<Power> powers ;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getIsShow() {
        return isShow;
    }
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
    public List<Power> getPowers() {
        return powers;
    }
    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getIsLay() {
        return isLay;
    }
    public void setIsLay(Integer isLay) {
        this.isLay = isLay;
    }
    @Override
    public String toString() {
        return "Power [id=" + id + ", pid=" + pid + ", title=" + title + ", type=" + type + ", state=" + state
                + ", sort=" + sort + ", url=" + url + ", icon=" + icon + ", description=" + description + ", isShow="
                + isShow + ", powers=" + powers + ", active=" + active + ", content=" + content + ", isLay=" + isLay
                + "]\n";
    }





}
