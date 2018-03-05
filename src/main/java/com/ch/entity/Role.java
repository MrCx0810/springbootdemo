package com.ch.entity;

/**
 * Created by IntelliJ IDEA.
 * @Description: 角色实体
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class Role {


    private  int id;

    private  String roleName;



    public  int  getId(){
        return  this.id;
    }
    public  void  setId(int id){
        this.id=id;
    }

    public  String  getRoleName(){
        return  this.roleName;
    }
    public  void  setRoleName(String roleName){
        this.roleName=roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
