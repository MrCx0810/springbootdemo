package com.ch.entity;

/**
 * Created by IntelliJ IDEA.
 * @Description: 用户实体
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class User {

    private  int id;
    /**
     * 登录名
     */
    private  String loginName;
    /**
     * 密码
     */
    private  String password;
    /**
     * 昵称
     */
    private  String niceName;
    /**
     * 禁用状态 0：未禁用 1：禁用
     */
    private  int state;
    /**
     * 发言禁用状态 0：可发言 1：禁止发言
     */
    private  int speakState;

    /**
     * 注册时间
     */
    private String regTime;

    /**
     * 微信openId 或 QQ openId
     */
    private String openId;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 黑名单状态
     */
    private int listState;



    public  int  getId(){
        return  this.id;
    };
    public  void  setId(int id){
        this.id=id;
    }

    public  String  getLoginName(){
        return  this.loginName;
    }
    public  void  setLoginName(String loginName){
        this.loginName=loginName;
    }

    public  String  getPassword(){
        return  this.password;
    }
    public  void  setPassword(String password){
        this.password=password;
    }

    public  String  getNiceName(){
        return  this.niceName;
    }
    public  void  setNiceName(String niceName){
        this.niceName=niceName;
    }

    public  int  getState(){
        return  this.state;
    }
    public  void  setState(int state){
        this.state=state;
    }

    public  int  getSpeakState(){
        return  this.speakState;
    }
    public  void  setSpeakState(int speakState){
        this.speakState=speakState;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getListState() {
        return listState;
    }

    public void setListState(int listState) {
        this.listState = listState;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", niceName='" + niceName + '\'' +
                ", state=" + state +
                ", speakState=" + speakState +
                ", regTime='" + regTime + '\'' +
                ", openId='" + openId + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", listState=" + listState +
                '}';
    }
}
