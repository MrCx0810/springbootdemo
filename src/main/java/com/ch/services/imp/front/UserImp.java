package com.ch.services.imp.front;

import com.ch.config.Contact;
import com.ch.dao.front.TokenDao;
import com.ch.dao.front.UserDao;
import com.ch.entity.User;
import com.ch.entity.UserToken;
import com.ch.enums.ResultEnum;
import com.ch.exception.MyException;
import com.ch.result.Result;
import com.ch.result.ResultUntil;
import com.ch.services.interf.front.UserInterf;
import com.ch.until.often.DateUtil;
import com.ch.until.often.OftenTool;
import com.ch.until.often.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * @Description: 用户管理实现
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:22
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserImp implements UserInterf{
    private final static Logger logger = Logger.getLogger(UserImp.class);

    @Autowired
    UserDao userDao;
    @Autowired
    TokenDao tokenDao;

    @Transactional
    @Override
    public Result getUserByLoginType(String name, String passWord, Integer type, String headUrl, String nickName, HttpSession session) throws Exception {
        String token = null;
        User user = null;
        String openId = null;
        if (StringUtils.isEmpty(type)) {
            throw new MyException(ResultEnum.TYPE_EMPTY);
        }
        if (type<=0 || type > Contact.WXLOGIN) {
            throw new MyException(ResultEnum.TYPE_ERROR);
        }

        if (StringUtils.isEmpty(name)) {
            throw new MyException(ResultEnum.LOGINNAME_EMPTY);
        }

        if (StringUtils.isEmpty(passWord)) {
            throw new MyException(ResultEnum.PSW_EMPTY);
        }
        user = userDao.queryUserByLoginName(name);
        if (StringUtils.isEmpty(user)) {
            throw new MyException(ResultEnum.USER_NOT_EXIST);
        }
        if (user.getState() == 2) {
            throw new MyException(ResultEnum.ACCOUNT_DISABLE);
        }
        try {
            String psw = OftenTool.md5Encode(passWord);
            if (!psw.equals(user.getPassword())) {
                throw new MyException(ResultEnum.PSW_ERROR);
            }
        }catch (Exception e){
            throw new MyException(ResultEnum.MD5_ERROR);
        }
        session.setAttribute("userId", user.getId());
        String tk = tokenDao.queryUserTokenByUid(user.getId());
        /**
         * 设置token
         */
        if (StringUtils.isEmpty(tk)) {
            UserToken userToken = new UserToken();
            userToken.setUid(user.getId());
            userToken.setTime(DateUtil.getOneDateTime(new Date(), "yyyy-MM-dd HH:mm:ss"));
            token = UUID.randomUUID().toString();
            userToken.setToken(token);
            System.out.println("token = " + token);
            tokenDao.insertUserToken(userToken);
        }


        /**
         * 用户已经存在，直接更新token
         */
        if (!StringUtils.isEmpty(user)) {
            token = UUID.randomUUID().toString();
            System.out.println("token = " + token);
            UserToken userToken = new UserToken();
            userToken.setToken(token);
            userToken.setTime(DateUtil.getOneDateTime(new Date(), "yyyy-MM-dd HH:mm:ss"));
            userToken.setUid(user.getId());
            tokenDao.updateUserToken(userToken);
        }

        Map<String, Object> map = new HashMap<>(3);
        map.put("token", token);
        map.put("openId", openId);

        return ResultUntil.success(map);
    }

    @Transactional
    @Override
    public Result addUser(String tel, String niceName, String passWord, String confirmPassWord) throws Exception {
        if (StringUtils.isEmpty(tel)) {
            throw  new MyException(ResultEnum.TEL_EMPTY);
        }
        if (StringUtils.isEmpty(niceName)) {
            throw  new MyException(ResultEnum.NICENAME_ERROR);
        }
        if (!OftenTool.isPhoneNumber(tel)) {
            throw  new MyException(ResultEnum.TEL_ERROR);
        }
        if (!passWord.equals(confirmPassWord)) {
            throw  new MyException(ResultEnum.PSW_NOT_EQUAL);
        }
        User user = userDao.queryUserByLoginName(tel);
        if (!StringUtils.isEmpty(user)) {
            throw  new MyException(ResultEnum.USER_ALREADY_EXIST);
        }
        User newUser = new User();
        newUser.setLoginName(tel);
        newUser.setNiceName(niceName);
        try {
            String psw = OftenTool.md5Encode(confirmPassWord);
            newUser.setPassword(psw);
        } catch (Exception e) {
            throw  new MyException(ResultEnum.MD5_ERROR);
        }
        newUser.setRegTime(DateUtil.getOneDateTime(new Date(), "yyyy-MM-dd HH:mm:ss"));
        int res = userDao.insertByUser(newUser);
        return ResultUntil.success();
    }

    @Override
    public void checkToken(String token) throws Exception{
        /**
         * Token验证
         */

        if (StringUtils.isEmpty(token)) {
            throw  new MyException(ResultEnum.TOKEN_EMPTY);
        }
        logger.info(token);
        UserToken userToken = tokenDao.queryUserByToken(token);
        System.out.println("userToken = " + userToken);
        if (StringUtils.isEmpty(userToken)) {
            throw new MyException(ResultEnum.TOKEN_NOT_EXIST);
        }

        String logTime = userToken.getTime();
        String nowTime = DateUtil.getOneDateTime(new Date(), "yyyy-MM-dd HH:mm:ss");
        double hour = DateUtil.subdateh(nowTime, logTime);
        /**
         * token 失效 24小时
         */
        if (hour>=24d) {
            logger.info("****************token失效**********************");
            throw new MyException(ResultEnum.TOKEN_INVALID);
        }
    }

    @Override
    public UserToken getUserToken(String token) {
        return tokenDao.queryUserByToken(token);
    }

    @Override
    public Result getUserById(int id) throws Exception{
        if (id<=0) {
            throw new MyException(ResultEnum.ID_ERROR);
        }
        User user = userDao.queryUserById(id);
        if (StringUtils.isEmpty(user)) {
            throw new MyException(ResultEnum.USER_NOT_EXIST);
        }
        return ResultUntil.success(user);
    }
}
