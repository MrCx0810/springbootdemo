package com.ch.controller.admin;


import com.ch.entity.Admin;
import com.ch.entity.Power;
import com.ch.entity.Role;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.*;
import com.ch.until.power.PowerUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LayerController {
	
	@Autowired
    PowerInter powerInter;

	@Autowired
	AdminPublicInter adminPubInter;

	@Autowired
	PlayerManagerInter playerInter;

	@Autowired
	AdminManagerInter adminManagerInter;

	@RequestMapping("layer/addAdmin")
	public void addAdmin(HttpSession session, Model model){
		int roleId = (int) session.getAttribute("roleId");
		List<Role> roles = powerInter.getRoleByRoleId(roleId);
		model.addAttribute("roles", roles);
	}
	@RequestMapping("layer/editAdmin")
	public void editAdmin(HttpSession session,Model model,Integer id){
		int roleId = (int) session.getAttribute("roleId");
		List<Role> roles = powerInter.getRoleByRoleId(roleId);
		System.out.println("roles = " + roles);
		Admin admin = adminPubInter.getAdminById(id);
		model.addAttribute("admin", admin);
		model.addAttribute("roles", roles);
	}
	@RequestMapping("layer/addCard")
	public void addCard(Model model,Integer id){
		model.addAttribute("id", id);
	}
	@RequestMapping("layer/addPlayerCar")
	public void addPlayerCar(Model model,Integer id){
		model.addAttribute("id", id);
	}
	@RequestMapping("layer/addRole")
	public void addRole(){

	}
	@RequestMapping("layer/editRole")
	public void editRole(Integer id,Model model){
		 model.addAttribute("id", id);
	}
	@RequestMapping("layer/powerRole")
	public void getPower(Integer id,Model model,HttpSession session){
		Integer roleId = (Integer) session.getAttribute("roleId");
		try {
			List<Power> powers = powerInter.getPowerByRoleId(id);//该角色拥有的权限
			List<Power> powers1 = powerInter.getPowerByRoleId(roleId);//分配者拥有的权限
			List<Power> resPower = PowerUntil.getPowerfp(powers, powers1);
			model.addAttribute("pows", resPower);
			model.addAttribute("id", id);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("layer/addPower")
	public void addPower(HttpSession session,Model model){
		Integer roleId = (Integer) session.getAttribute("roleId");
		try {
			List<Power> powers = powerInter.getPowerByRoleId(roleId);
			model.addAttribute("pws", powers);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
