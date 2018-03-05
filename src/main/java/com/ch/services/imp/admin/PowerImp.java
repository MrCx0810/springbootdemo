package com.ch.services.imp.admin;

import com.ch.dao.admin.AdminDao;
import com.ch.dao.admin.PowerDao;
import com.ch.entity.Admin;
import com.ch.entity.Power;
import com.ch.entity.Role;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.PowerInter;
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
 * @Description: 权限管理实现
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 21:45
 * To change this template use File | Settings | File Templates.
 */

@Service
public class PowerImp implements PowerInter {
	@Autowired
    PowerDao powerDao;
	@Autowired
	AdminDao adminDao;

	@Override
	public List<Power> getPowerByRoleId(Integer roleId) throws MyException {
		if(roleId==null){
			throw new MyException("请填入角色ID");
		}
		List<Power> powers = powerDao.queryPowerByRoleId(roleId);
		return powers;
	}
	@Override
	public Map<String, Object> getAdminsByRoleId(Integer roleId, Integer pageNo, Integer pageSize) throws MyException {
		Map<String, Object> map = new HashMap<>();
		if(roleId==null){
			throw new MyException("请填写角色ID");
		}
		Integer st = null;
		Integer size = null;
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<String, Object>();
			if(pageNo<=0){
				throw new MyException("当前页数不能小于0");
			}
			if(pageSize<=0){
				throw new MyException("每页数量不能小于0");
			}
			Integer totalNum = adminDao.getCountAdminNum(1);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}

		List<Admin> admins = powerDao.queryAdmin(roleId, st, size);
		map.put("admins", admins);
		return map;
	}
	@Override
	public List<Role> getRoleByRoleId(Integer roleId) {
		List<Role> roles = powerDao.queryRole(roleId);
		return roles;
	}

	@Transactional
	@Override
	public void setAdmin(String loginName, String loginPassword, String name, String phoneNumber, Integer roleId, Integer fid) throws MyException {
		if(OftenTool.IsNull(loginName)){
			throw new MyException("请输入用户账号");
		}
		if(OftenTool.IsNull(loginPassword)){
			throw new MyException("请输入密码");
		}
		if(OftenTool.IsNull(name)){
			throw new MyException("请输入姓名");
		}
		if(OftenTool.IsNull(phoneNumber)){
			throw new MyException("请输入电话");
		}
		if(!OftenTool.isPhoneNumber(phoneNumber)) {
			throw new MyException("请输入正确的电话");
		}
		if(roleId==null){
			throw new MyException("请选择角色");
		}
		if(fid == null) {
			throw new MyException("请登录后操作");
		}
		Admin admin = powerDao.queryAdminByLogin(loginName);
		if(admin!=null){
			throw new MyException("账号已经存在");
		}
		String MD5psw = null;
		try {
			MD5psw = OftenTool.md5Encode(loginPassword);
		} catch (Exception e) {
			throw new MyException("内部加密异常");
		}
		Role role = powerDao.queryRoleById(roleId);
		Admin addAdmin = new Admin();
		addAdmin.setLoginName(loginName);
		addAdmin.setLoginPassword(MD5psw);
		addAdmin.setName(name);
		addAdmin.setPhoneNumber(phoneNumber);
		addAdmin.setRoleId(roleId);
		addAdmin.setFid(fid);
		addAdmin.setRoleName(role.getRoleName());
        powerDao.insertAdmin(addAdmin);

	}

	@Transactional
	@Override
	public void setAdminState(Integer id, Integer state, Integer adminId) throws MyException {
		if(id==null){
			throw new MyException("请传入禁用者ID");
		}
		if(state==null){
			throw new MyException("请传入状态");
		}
        powerDao.updateAdminState(id,state,null);
		Admin admin = powerDao.queryAdminById(id);

	}
	@Transactional
	@Override
	public void updateAdminById(Admin admin, Integer adminId) throws MyException {
		if(OftenTool.IsNull(admin.getLoginName())){
			throw new MyException("请传入登录名");
		}
		if(admin.getId()==null){
			throw new MyException("请传入ID");
		}
		if(OftenTool.IsNull(admin.getName())) {
			throw new MyException("请传入姓名");
		}
		if(!OftenTool.isPhoneNumber(admin.getPhoneNumber())) {
			throw new MyException("请传入正确的电话");
		}
		if(admin.getRoleId()==null){
			throw new MyException("请传入角色ID");
		}
		if(OftenTool.IsNull(admin.getLoginPassword())){
			admin.setLoginPassword(null);
		}else{
			String md5psw = null;
			try {
				md5psw = OftenTool.md5Encode(admin.getLoginPassword());
			} catch (Exception e) {
				throw new MyException("内部加密异常");
			}
			admin.setLoginPassword(md5psw);
		}
		Role role = powerDao.queryRoleById(admin.getRoleId());
		admin.setRoleName(role.getRoleName());
        powerDao.updateAdminById(admin);



	}
	@Transactional
	@Override
	public void setRole(String roleName, Integer adminId) throws MyException {
		if(OftenTool.IsNull(roleName)){
			throw new MyException("请填写角色名称");
		}
		Role role = powerDao.queryRoleByRoleName(roleName);
		if(role!=null){
			throw new MyException("该角色已经存在");
		}
        powerDao.insertRole(roleName);


	}
	@Transactional
	@Override
	public void delRole(Integer id, Integer adminId) throws MyException {
		if(adminId ==null|| adminId <=0){
			throw new MyException("请传入角色ID");
		}
        powerDao.delRoleById(adminId);
        powerDao.delMidByRoleId(adminId);

		Role role = powerDao.queryRoleById(id);
		Admin admin = adminDao.queryAdminById(adminId);

	}

	@Transactional
	@Override
	public void updateRoleById(Integer id, String roleName, Integer adminId) throws MyException {
		if(id==null){
			throw new MyException("请传入角色ID");
		}
		if(OftenTool.IsNull(roleName)){
			roleName=null;
		}else{
            powerDao.updateRoleById(id, roleName);
			Role role = powerDao.queryRoleById(id);
		}
	}
	@Transactional
	@Override
	public void setPower(Integer id, String[] str, Integer adminId) throws MyException {
		if(id==null){
			throw new MyException("请传入角色ID");
		}
		if (adminId == null) {
			throw new MyException("请操作者ID");
		}
		//删除角色的所有权限
        powerDao.delMidByRoleId(id);
		for(int i=1;i<str.length;i++){
			Integer powerId = Integer.valueOf(str[i]);
            powerDao.insertMid(id,powerId);
		}


	}
	@Transactional
	@Override
	public void addPower(Power power, Integer adminId) throws MyException {
		if(OftenTool.IsNull(power.getTitle())){
			throw new MyException("请填入标题");
		}
        powerDao.insertPower(power);

	}
	@Transactional
	@Override
	public void setAdminListState(Integer id, Integer listState, Integer adminId) throws MyException {
		if(id==null){
			throw new MyException("请传入黑名单者ID");
		}
		if(listState==null){
			throw new MyException("请传入状态");
		}
		Admin admin1 = adminDao.queryAdminById(id);
		if (StringUtils.isEmpty(admin1)) {
			throw new MyException("该用户不存在");
		}
		powerDao.updateAdminState(id,null,listState);
	}

	@Override
	public Map<String, Object> getBlackAdminsList(Integer pageNo, Integer pageSize) throws MyException {
		Map<String, Object> map = new HashMap<>();
		Integer st = null;
		Integer size = null;
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<>(3);
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
		map.put("blackList", admins);
		return map;
	}
}
