package com.ch.entity;

/**
 * Created by IntelliJ IDEA.
 * @Description: 角色权限中间实体
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public class PowerMidRole {


    private  int id;
    /**
     * 权限id
     */
    private  int powerId;
    /**
     * 角色id
     */
    private  int roleId;



    public  int  getId(){
        return  this.id;
    }
    public  void  setId(int id){
        this.id=id;
    }

    public  int  getPowerId(){
        return  this.powerId;
    }
    public  void  setPowerId(int powerId){
        this.powerId=powerId;
    }

    public  int  getRoleId(){
        return  this.roleId;
    }
    public  void  setRoleId(int roleId){
        this.roleId=roleId;
    }

    @Override
    public String toString() {
        return "PowerMidRole{" +
                "id=" + id +
                ", powerId=" + powerId +
                ", roleId=" + roleId +
                '}';
    }
}
