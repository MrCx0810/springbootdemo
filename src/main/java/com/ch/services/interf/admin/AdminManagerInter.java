package com.ch.services.interf.admin;

import com.ch.exception.MyException;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public interface AdminManagerInter {
	
	/**
	 * 查询某个id的所有代理商
	 * @param fid
	 * @return
	 * @throws MyException 
	 */
	Map<String, Object> queryMyAdmins(Integer fid, Integer pageNo, Integer pageSize) throws MyException, MyException;
	

	/**
	 * 根据昵称 搜索代理商
	 * @param pageNo
	 * @param pageSize
	 * @param aid 父级id
	 * @return
	 * @throws MyException 
	 */
	Map<String, Object> getSearchMyAdminsList(Integer pageNo, Integer pageSize, String str, Integer aid) throws MyException;


	/**
	 * 获取黑名单代理商
	 * @param aid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	Map<String, Object> queryBlackAdmins(Integer aid, Integer pageNo, Integer pageSize) throws MyException;
	/***
	 * 代理商黑名单搜索
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @param aid
	 * @return
	 * @throws MyException 
	 */
	Map<String, Object> getSearchBlackAdminsList(Integer pageNo, Integer pageSize, String name, Integer aid) throws MyException;

	/**
	 * 删除管理员
	 * @param id
	 * @param adminId
	 */
	void deleteAdmin(Integer id, Integer adminId);


}
