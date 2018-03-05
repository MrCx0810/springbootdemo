package com.ch.controller.admin;

import com.ch.exception.MyException;
import com.ch.services.interf.admin.PlayerManagerInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @Description:用户管理模块
 * @author: 小小小阿曦
 * @Date: 2017/12/27
 * @Time: 23:39
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("admin/")
public class PlayerManagerController {
	@Autowired
	PlayerManagerInter playerInter;

	/**
	 * 获取所有玩家信息，白名单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getPlayers")
	Object getPlayers(Integer pageNo, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		try {
			Map<String, Object> PlayersData = playerInter.queryAllPlayers(pageNo, pageSize);
			map.put("code",200);
			map.put("players", PlayersData);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	/**
	 * 获取所有用户信息，黑名单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getBlackPlayers")
	Object getBlackPlayers(Integer pageNo, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> PlayersData = playerInter.queryAllPlayers2(pageNo, pageSize);
			map.put("code",200);
			map.put("players", PlayersData);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}


	/**
	 * 搜索用户
	 * @param state
	 * @return
	 */
	@RequestMapping("getSearchPlayers")
	Object getSearchPlayers(Integer pageNo, Integer pageSize, Integer state,String name, Integer listState){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			 Map<String, Object> mapDate = playerInter.getPlayersByNiceName(pageNo, pageSize, state, name, listState);
			map.put("code", 200);
			map.put("search_players", mapDate);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}

	/**
	 * 筛选用户
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	@RequestMapping("getUsersListByType")
	Object getUsersListByType(Integer pageNo, Integer pageSize, Integer type){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			 Map<String, Object> mapDate = playerInter.getUsersListByType(pageNo, pageSize, type);
			map.put("code", 200);
			map.put("search_players", mapDate);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}



}
