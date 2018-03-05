package com.ch.services.imp.admin;


import com.ch.dao.admin.AdminDao;
import com.ch.entity.Admin;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.AdminManagerInter;
import com.ch.until.often.OftenTool;
import com.ch.until.often.PageUtil;
import com.ch.until.often.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 21:45
 * To change this template use File | Settings | File Templates.
 */

@Service
public class AdminManagerImp implements AdminManagerInter {
	
	@Autowired
	AdminDao adminDao;


	@Override
	public Map<String, Object> queryMyAdmins(Integer fid,Integer pageNo, Integer pageSize) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer st = null;
		Integer size = null;
		if(fid == null) {
			throw new MyException("请传入管理员ID");
		}
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<String, Object>();
			if(pageNo<=0){
				throw new MyException("当前页数不能小于0");
			}
			if(pageSize<=0){
				throw new MyException("每页数量不能小于0");
			}
			Integer totalNum = adminDao.getCountByFidAndRid(fid, 4, 1, null,1);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<Admin> myadmins = adminDao.queryMyAdminByFidAndRoleId(fid, 4, null, null,1, st, size);
		if(myadmins.isEmpty()) {
			throw new MyException("暂无代理商");
		}
		map.put("MyAdmins",myadmins);			
		return map;
	}



	@Override
	public Map<String, Object> getSearchMyAdminsList(Integer pageNo, Integer pageSize, String str, Integer adminId) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer st = null;
		Integer size = null;
		if(OftenTool.IsNull(str)) {
			throw new MyException("请输入账号/手机号查询");
		}
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<String, Object>();
			if(pageNo<=0){
				throw new MyException("当前页数不能小于0");
			}
			if(pageSize<=0){
				throw new MyException("每页数量不能小于0");
			}
			Integer totalNum = adminDao.getCountByFidAndRid(adminId, 4, null, str, 1);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<Admin> admins = adminDao.queryMyAdminByFidAndRoleId(adminId, 4, null, str, 1, st, size);
		System.out.println("代理商查询结果===="+admins);
		if(admins.isEmpty()) {
			throw new MyException("搜索代理商不存在");
		}
		map.put("MyAdmins",admins);			
		return map;
		
	}
	@Override
	public Map<String, Object> getSearchBlackAdminsList(Integer pageNo, Integer pageSize, String str, Integer aid) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer st = null;
		Integer size = null;
		if(OftenTool.IsNull(str)) {
			throw new MyException("请输入账号/手机号查询");
		}
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<String, Object>();
			if(pageNo<=0){
				throw new MyException("当前页数不能小于0");
			}
			if(pageSize<=0){
				throw new MyException("每页数量不能小于0");
			}
			Integer totalNum = adminDao.getCountByFidAndRid(aid, 4, null, str, 2);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<Admin> admins = adminDao.queryMyAdminByFidAndRoleId(aid, 4, null, str, 2, st, size);
		if(admins.isEmpty()) {
			throw new MyException("搜索代理商不存在");
		}
		map.put("AdminsBlackList",admins);			
		return map;
		
	}



    @Transactional
    @Override
    public void deleteAdmin(Integer id, Integer adminId) throws MyException{
        if (id == null) {
            throw new MyException("请传入管理员ID");
        }
        Admin admin = adminDao.queryAdminById(id);
        if (StringUtils.isEmpty(admin)) {
            throw new MyException("该管理员不存在");
        }
        adminDao.deleteAdminById(id);
    }




    @Override
	public Map<String, Object> queryBlackAdmins(Integer fid, Integer pageNo, Integer pageSize) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer st = null;
		Integer size = null;
		if(fid == null) {
			throw new MyException("请传入管理员ID");
		}
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<String, Object>();
			if(pageNo<=0){
				throw new MyException("当前页数不能小于0");
			}
			if(pageSize<=0){
				throw new MyException("每页数量不能小于0");
			}
			Integer totalNum = adminDao.getCountByListState(2);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<Admin> admins = adminDao.queryAdminsByListState(2, st, size);
		if(StringUtils.isEmpty(admins)) {
			throw new MyException("黑名单暂无管理员");
		}
        System.out.println("myAdmins = " + admins);
		map.put("AdminsBlackList",admins);
		return map;
	}
	
}
