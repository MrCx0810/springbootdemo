package com.ch.services.imp.admin;

import com.ch.dao.admin.AdminDao;
import com.ch.dao.front.UserDao;
import com.ch.entity.User;
import com.ch.exception.MyException;
import com.ch.services.interf.admin.PlayerManagerInter;
import com.ch.until.often.OftenTool;
import com.ch.until.often.PageUtil;
import com.ch.until.often.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PlayerManagerImp implements PlayerManagerInter {
	@Autowired
    UserDao userDao;
	@Autowired
	AdminDao adminDao;

	@Override
	public Map<String, Object> queryAllPlayers(Integer pageNo, Integer pageSize) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
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
			Integer totalNum = userDao.getCountOfPlayer(1, null, 1);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
        List<User> users = userDao.queryAllUser(1, st, size);
		if(StringUtils.isEmpty(users)) {
			throw new MyException("暂无用户");
		}
		map.put("allPlayer",users);
		return map;
	}
	@Override
	public Map<String, Object> queryAllPlayers2(Integer pageNo, Integer pageSize) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
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
			Integer totalNum = userDao.getCountOfPlayer(2, null, 2);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<User> allPlayer = userDao.queryAllUser(2, st, size);
		if(allPlayer.isEmpty()) {
			throw new MyException("暂无用户");
		}
		map.put("blackList",allPlayer);
		return map;
	}


	@Override
	public Map<String, Object> getPlayersByNiceName(Integer pageNo, Integer pageSize,Integer state,String name, Integer listState) throws MyException {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer st = null;
		Integer size = null;
		if(OftenTool.IsNull(name)) {
			throw new MyException("请输入昵称查询");
		}
		if(state == null || state<0) {
			throw new MyException("参数不合法");
		}
		if(pageNo!=null&&pageSize!=null){
			Map<String,Object>map1 = new HashMap<String, Object>();
			if(pageNo<=0){
				throw new MyException("当前页数不能小于0");
			}
			if(pageSize<=0){
				throw new MyException("每页数量不能小于0");
			}
			Integer totalNum = userDao.getCountOfPlayer(state, name, listState);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<User> users = userDao.queryPlayersByNiceName(name,  st, size, state, 1);

		if(StringUtils.isEmpty(users)) {
			throw new MyException("搜索用户不存在");
		}
		System.out.println("users 搜索 = " + users);
		map.put("allplayers",users);
		return map;

	}

	@Override
	public Map<String, Object> getUsersListByType(Integer pageNo, Integer pageSize, Integer type) throws  MyException{
		Map<String, Object> map = new HashMap<>(2);
		if(type == null) {
			throw new MyException("参数不合法");
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
			Integer totalNum = userDao.getCountOfPlayerByType(type, 1);
			PageUtil page = new PageUtil(pageNo, pageSize, totalNum);
			st = page.getStartLoc();
			size = pageSize;
			map1.put("pageNo", pageNo);//当前页数
			map1.put("pageSize", pageSize);//每页数据量
			map1.put("totalPage", page.getTotalPage());//总页数
			map.put("page", map1);
		}
		List<User> users = userDao.queryPlayersByType(type, st, size);
		System.out.println("筛选 users===="+users);
		if(StringUtils.isEmpty(users)) {
			throw new MyException("没有符合此条件的用户");
		}
		map.put("allplayers",users);
		return map;
	}

}
