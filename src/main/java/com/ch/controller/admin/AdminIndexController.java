package com.ch.controller.admin;

import com.ch.entity.Admin;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.AdminIndexInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



@Controller
public class AdminIndexController {
	@Autowired
	AdminIndexInter adminIndex;
	
	@RequestMapping(value="/doAdminlogin")
	@ResponseBody
	Object doAdminLogin(String loginName,String psw,HttpSession session){
		Map<String, Object> map = new HashMap<>(2);
		try {
			Admin admin = adminIndex.adminLogin(loginName, psw);
			session.setAttribute("adminId", admin.getId());
			session.setAttribute("roleId", admin.getRoleId());
			session.setAttribute("ax", "admin");
			System.out.println("session ===="+session.getAttribute("roleId"));
			map.put("code", "100");
			map.put("data", admin);
		} catch (MyException e) {
			map.put("code", "500");
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="layout")
	void layOut(HttpSession session, HttpServletResponse res, HttpServletRequest req) throws IOException {
		session.invalidate();
		res.sendRedirect(req.getContextPath()+"/admin/adminLogin");
	}
}
