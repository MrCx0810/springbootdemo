package com.ch.dao.front;

import com.ch.entity.UserToken;
import org.apache.ibatis.annotations.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/29
 * @Time: 12:04
 * To change this template use File | Settings | File Templates.
 */
@Mapper
public interface TokenDao {
    /**
    * @Author:小小小阿曦
    * @Date: 12:08-2017/12/29
    * @Description: 修改用户token 和 过期时间
     * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_usertoken SET token=#{token}, time=#{time} WHERE uid=#{uid}")
    void updateUserToken(UserToken userToken);
    /**
    * @Author:小小小阿曦
    * @Date: 12:08-2017/12/29
    * @Description: 添加用户token
     * @Param null  param desc
    * @Return:
    */
    @Insert("INSERT INTO ch_usertoken(token, time, uid) VALUES(#{token},#{time},#{uid})")
    int insertUserToken(UserToken userToken);

    /**
    * @Author:小小小阿曦
    * @Date: 13:40-2017/12/29
    * @Description: 通过id查询token
     * @Param null  param desc
    * @Return:
    */
    @Select("SELECT token FROM ch_usertoken WHERE uid=#{uid}")
    String queryUserTokenByUid(int uid);

    /**
    * @Author:小小小阿曦
    * @Date: 13:41-2017/12/29
    * @Description: 通过Token查询用户id
     * @Param null  param desc
    * @Return:
    */
    @Select("SELECT * FROM ch_usertoken WHERE token=#{token}")
    UserToken queryUserByToken(@Param("token") String token);
}
