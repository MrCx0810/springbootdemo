package com.ch.controller.admin;


import com.ch.entity.Power;
import com.ch.entity.Role;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.PowerInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AdminPublicController {
	
	@Autowired
	PowerInter powerInter;

	@RequestMapping(value="admin/index")
	void adminIndex(){
	}
	@RequestMapping(value="admin/user")
	public void user (){

	}
	@RequestMapping("admin/adminUser")
	@ResponseBody
	Object adminUser(Integer pageNo, Integer pageSize, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		try {
			Integer roleId = (Integer) session.getAttribute("roleId");
			Map<String,Object> data = powerInter.getAdminsByRoleId(roleId, pageNo, pageSize);
			map.put("code", 200);
			map.put("data", data);
		} catch (MyException e) {
			map.put("code", 200);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="admin/role")
	void role(HttpSession session,Model model){
		Integer roleId = (Integer) session.getAttribute("roleId");
		List<Role> roles = powerInter.getRoleByRoleId(roleId);
		model.addAttribute("roles", roles);
	}
	@RequestMapping(value="admin/power")
	void power(HttpSession session,Model model){
		Integer roleId = (Integer) session.getAttribute("roleId");
		try {
			List<Power> powers = powerInter.getPowerByRoleId(roleId);
			model.addAttribute("allpower", powers);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="admin/two")
	void two(){
	}
	@RequestMapping(value="/404")
	String error(){
		return"404";
	}

	@RequestMapping(value="/errors")
	String errors(){
		return "error";
	}

	@RequestMapping(value="admin/adminLogin")
	void adminLogin(){

	}
	@RequestMapping("admin/login")
	void login(){

	}

}
