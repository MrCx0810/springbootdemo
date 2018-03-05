package com.ch.services.interf.admin;

import com.ch.entity.Admin;


/**
 * Created by IntelliJ IDEA.
 * @Description: 后台公共接口
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public interface AdminPublicInter {
	/**
	 * 通过ID查询管理员用户
	 * @param id：用户ID 
	 * @return admin
	 */
	 Admin getAdminById(Integer id);
}
