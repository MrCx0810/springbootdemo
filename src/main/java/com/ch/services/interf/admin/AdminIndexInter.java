package com.ch.services.interf.admin;

import com.ch.entity.Admin;
import com.ch.exception.MyException;

/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public interface  AdminIndexInter {
	/**
	 * 管理员登录
	 * @param loginName:登录账号  psw：登录密码
	 * @return Admin
	 */
	public Admin adminLogin(String loginName, String psw) throws MyException;
	
	
}
