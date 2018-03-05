package com.ch.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 用户token
 * @author: 小小小阿曦
 * @Date: 2017/12/29
 * @Time: 11:54
 * To change this template use File | Settings | File Templates.
 */
public class UserToken {

    private Integer id;
    /**
     * token值
     */
    private String token;
    /**
     * 更新时间
     */
    private String time;
    /**
     * 用户id
     */
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", time=" + time +
                ", uid=" + uid +
                '}';
    }
}
