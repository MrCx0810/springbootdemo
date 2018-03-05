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
public interface PlayerManagerInter {
	/**
	 * 获取所有玩家信息,白名单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws MyException
	 */
	Map<String, Object> queryAllPlayers(Integer pageNo, Integer pageSize) throws MyException;
	/**
	 * 获取所有玩家信息,黑名单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws MyException
	 */
	Map<String, Object> queryAllPlayers2(Integer pageNo, Integer pageSize) throws MyException;

	/**
	 * 昵称搜索玩家信息
	 * @param name
	 * @return
	 * @throws MyException
	 */
	Map<String, Object> getPlayersByNiceName(Integer pageNo, Integer pageSize, Integer state, String name, Integer listState)throws MyException;

	/**
	 * 筛选用户
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	Map<String,Object> getUsersListByType(Integer pageNo, Integer pageSize, Integer type) throws MyException;

}
