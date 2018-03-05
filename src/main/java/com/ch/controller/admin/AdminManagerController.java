package com.ch.controller.admin;

import com.ch.exception.MyException;
import com.ch.services.interf.admin.AdminManagerInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 代理商管理模块
 * @author JayZhou
 *
 */

@RestController
@RequestMapping("admin/")
public class AdminManagerController {
	
	@Autowired
	AdminManagerInter adminManagerInter;

	/**
	 * 获取管理员列表
	 * @param session
	 * @return
	 */
	@RequestMapping("getMyAdmins")
	Object queryMyAdmins(Integer pageNo, Integer pageSize,HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer aid = (Integer)session.getAttribute("adminId");
		try {
			Map<String, Object> AdminsData = adminManagerInter.queryMyAdmins(aid, pageNo, pageSize);
			map.put("code",200);
			map.put("myadmins", AdminsData);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}

	/**
	 * 搜索获取管理员列表
	 * @param session
	 * @return
	 */
	@RequestMapping("getSearchMyAdmins")
	Object getSearchMyAdmins(Integer pageNo, Integer pageSize,String name, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer aid = (Integer)session.getAttribute("adminId");
		System.out.println(name);
		try {
			Map<String, Object> AdminsData = adminManagerInter.getSearchMyAdminsList(pageNo, pageSize, name, aid);
			map.put("code",200);
			map.put("myadmins", AdminsData);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}

	/**
	 * 管理员黑名单搜索
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @param session
	 * @return
	 */
	@RequestMapping("getSearchBalckAdmins")
	Object getSearchBalckAdmins(Integer pageNo, Integer pageSize,String name, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer aid = (Integer)session.getAttribute("adminId");
			Map<String, Object> AdminsData = adminManagerInter.getSearchBlackAdminsList(pageNo, pageSize, name, aid);
			map.put("code",200);
			map.put("search_admins", AdminsData);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}

	/**
	 * 获取所有管理员信息，黑名单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getBlackAdmins")
	Object getBlackAdmins(Integer pageNo, Integer pageSize, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer aid = (Integer)session.getAttribute("adminId");
		try {
			Map<String, Object> PlayersData = adminManagerInter.queryBlackAdmins(aid, pageNo, pageSize);
			map.put("code",200);
			map.put("data", PlayersData);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}

	/**
	 * 删除管理员
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("delAdmin")
	Object delAdmin(Integer id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer)session.getAttribute("adminId");
			adminManagerInter.deleteAdmin(id, adminId);
			map.put("code",100);
		} catch (MyException e) {
			map.put("code",500);
			map.put("msg", e.getMessage());
		}
		return map;
	}




}
