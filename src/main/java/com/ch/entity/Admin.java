package com.ch.entity;

/**
 * Created by IntelliJ IDEA.
 * @Description: 管理员实体
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class Admin {

    private  Integer id;

    /**
     * 登录名
     */
    private  String loginName;
    /**
     * 密码
     */
    private  String loginPassword;
    /**
     * 姓名
     */
    private  String name;
    /**
     * 身份证号
     */
    private  String carNumber;
    /**
     * ip地址
     */
    private  String loginIp;
    /**
     * 父级id
     */
    private  int fid;
    /**
     * 角色id
     */
    private  Integer roleId;
    /**
     * 是否删除状态
     */
    private  int isDel;
    /**
     * 电话号码
     */
    private  String phoneNumber;
    /**
     * 上一次登录时间
     */
    private  String lastLoginTime;
    /**
     * 状态
     */
    private  int state;
    /**
     * 黑名单状态
     */
    private  int listState;
    /**
     * 角色名
     */
    private String roleName;



    public  Integer  getId(){
        return  this.id;
    }
    public  void  setId(Integer id){
        this.id=id;
    }

    public  String  getLoginName(){
        return  this.loginName;
    }
    public  void  setLoginName(String loginName){
        this.loginName=loginName;
    }

    public  String  getLoginPassword(){
        return  this.loginPassword;
    }
    public  void  setLoginPassword(String loginPassword){
        this.loginPassword=loginPassword;
    }

    public  String  getName(){
        return  this.name;
    }
    public  void  setName(String name){
        this.name=name;
    }

    public  String  getCarNumber(){
        return  this.carNumber;
    }
    public  void  setCarNumber(String carNumber){
        this.carNumber=carNumber;
    }

    public  String  getLoginIp(){
        return  this.loginIp;
    }
    public  void  setLoginIp(String loginIp){
        this.loginIp=loginIp;
    }

    public  int  getFid(){
        return  this.fid;
    }
    public  void  setFid(int fid){
        this.fid=fid;
    }

    public  Integer  getRoleId(){
        return  this.roleId;
    }
    public  void  setRoleId(Integer roleId){
        this.roleId=roleId;
    }

    public  int  getIsDel(){
        return  this.isDel;
    }
    public  void  setIsDel(int isDel){
        this.isDel=isDel;
    }

    public  String  getPhoneNumber(){
        return  this.phoneNumber;
    }
    public  void  setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public  String  getLastLoginTime(){
        return  this.lastLoginTime;
    }
    public  void  setLastLoginTime(String lastLoginTime){
        this.lastLoginTime=lastLoginTime;
    }

    public  int  getState(){
        return  this.state;
    }
    public  void  setState(int state){
        this.state=state;
    }

    public int getListState() {
        return listState;
    }

    public void setListState(int listState) {
        this.listState = listState;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", fid=" + fid +
                ", roleId=" + roleId +
                ", isDel=" + isDel +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", state=" + state +
                ", listState=" + listState +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
