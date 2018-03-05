package com.ch.services.interf.admin;

import com.ch.entity.Admin;
import com.ch.entity.Power;
import com.ch.entity.Role;
import com.ch.exception.MyException;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public interface PowerInter {
	/**
	 * 获取某个角色的所有权限
	 * @param roleId
	 * @return List<Power>
	 */
	 List<Power> getPowerByRoleId(Integer roleId) throws MyException;
	/**
	 * 获取管理员白名单列表
	 * @param roleId
	 * List<Admin>
	 * @param pageNo
	 * @param pageSize
	 */
	 Map<String, Object> getAdminsByRoleId(Integer roleId, Integer pageNo, Integer pageSize) throws MyException;
	/**
	 * 获取角色列表
	 */
	 List<Role> getRoleByRoleId(Integer roleId);
	/**
	 * 添加管理员账号
	 * @param loginName:账号 psw:密码 roleId:角色ID
	 * @return void 
	 */
	 void setAdmin(String loginName, String lognPassword, String name, String phoneNumber, Integer roleId, Integer fid) throws MyException;
	/**
	 * 改变管理员账号的状态
	 * @param id ：管理员ID,state:状态
	 * @param adminId
	 * @return void
	 */
	 void setAdminState(Integer id, Integer state, Integer adminId) throws MyException;
	/**
	 * 更新管理员账号
	 * @param admin :管理员实体
	 * @param adminId
	 * @return void
	 */
	 void updateAdminById(Admin admin, Integer adminId) throws MyException;
	/**
	 * 添加角色
	 * @param roleName :角色名称
	 * @param adminId
	 * @return void
	 */
	 void setRole(String roleName, Integer adminId) throws  MyException;
	/**
	 * 通过角色ID删除角色
	 * @param id ：角色id
	 * @param adminId ：角色id
	 * @return void
	 */
	 void delRole(Integer id, Integer adminId) throws MyException;
	/**
	 * 更新角色信息
	 * @param id ：角色ID roleName:角色名
	 * @param adminId
	 * @return void
	 */
	 void updateRoleById(Integer id, String roleName, Integer adminId) throws MyException;
	/**
	 * 为角色分配权限
	 * @param str :选中的权限ID数组
	 * @param adminId
	 * @return void
	 */
	 void setPower(Integer id, String[] str, Integer adminId) throws MyException;
	/**
	 * 添加权限
	 * @param power
	 * @param adminId
	 * @return void
	 */
	 void addPower(Power power, Integer adminId) throws MyException;
	/**
	 * 管理员加入黑名单
	 * @param id
	 * @param listState
	 * @param adminId
	 * @throws MyException
	 */
	 void setAdminListState(Integer id, Integer listState, Integer adminId) throws MyException;

	/**
	 * 获取管理员黑名单
	 * @param pageNo
	 * @param pageSize
	 */
	 Map<String, Object> getBlackAdminsList(Integer pageNo, Integer pageSize) throws MyException;
}
