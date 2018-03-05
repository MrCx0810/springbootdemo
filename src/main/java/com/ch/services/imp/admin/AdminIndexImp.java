package com.ch.services.imp.admin;

import com.ch.dao.admin.AdminDao;
import com.ch.entity.Admin;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.AdminIndexInter;
import com.ch.until.often.OftenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 21:45
 * To change this template use File | Settings | File Templates.
 */

@Service
public class AdminIndexImp implements AdminIndexInter {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin adminLogin(String loginName, String psw) throws MyException {
		if(OftenTool.IsNull(loginName)){
			throw new MyException("请输入登录名");
		}
		if(OftenTool.IsNull(psw)){
			throw new MyException("请输入密码");
		}
		Admin admin = adminDao.queryAdminByLoginName(loginName);
		if(admin==null){
			throw new MyException("用户不存在");
		}
		if(admin.getState()==0){
			throw new MyException("用户已经被禁用");
		}
		String Md5psw = null;
		try {
			Md5psw = OftenTool.md5Encode(psw);
		} catch (Exception e) {
			throw new MyException("内部加密异常");
		}
		if(!admin.getLoginPassword().equals(Md5psw)){
			throw new MyException("密码错误");
		}
		return admin;
	}

}
