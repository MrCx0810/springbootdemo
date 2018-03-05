package com.ch.services.imp.admin;

import com.ch.dao.admin.PowerDao;
import com.ch.entity.Admin;
import com.ch.services.interf.admin.AdminPublicInter;
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
public class AdminPublicImp implements AdminPublicInter {
	
	@Autowired
	PowerDao powerDao;

	@Override
	public Admin getAdminById(Integer id) {
		Admin admin = powerDao.queryAdminById(id);
		return admin;
	}

}
