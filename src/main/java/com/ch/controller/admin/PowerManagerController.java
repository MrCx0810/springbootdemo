package com.ch.controller.admin;

import com.ch.entity.Admin;
import com.ch.entity.Power;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.PowerInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @Description: 权限管理控制器
 * @author: 小小小阿曦
 * @Date: 2017/12/27
 * @Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class PowerManagerController {
	
	@Autowired
	PowerInter powerInter;

	//添加代理商
	@RequestMapping("admin/addUser")
	Object addUser(String loginName, String loginPassword, String name, String phoneNumber, Integer roleId, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.setAdmin(loginName, loginPassword, name, phoneNumber, roleId, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("admin/updateAdminState")
	Object updateState(Integer id,Integer state, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.setAdminState(id, state, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping("admin/updateAdminListState")
	Object updateAdminListState(Integer id, Integer listState, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.setAdminListState(id, listState, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/editAdmin")
	Object editAdmin(Admin admin, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.updateAdminById(admin, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/addRole")
	Object addRole(String roleName, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.setRole(roleName, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/delRole")
	Object delRole(Integer id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.delRole(id, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/editRole")
	Object editRole(Integer id,String roleName, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.updateRoleById(id, roleName, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/updatePower")
	Object updatePower(Integer roleId,String s, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		String str[] = s.split(",");
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.setPower(roleId, str, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/addPower")
	Object addPower(Power power, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer adminId = (Integer) session.getAttribute("adminId");
			powerInter.addPower(power, adminId);
			map.put("code", 100);
		} catch (MyException e) {
			map.put("code", 500);
			map.put("msg", e.getMessage());
		}
		return map;
	}


}
