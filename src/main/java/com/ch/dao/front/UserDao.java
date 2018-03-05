package com.ch.dao.front;

import com.ch.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Description: 用户管理
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 14:35
 * To change this template use File | Settings | File Templates.
 */

@Mapper
public interface UserDao {
    
    /**
    * @Author:小小小阿曦
    * @Date: 14:38-2017/12/22
    * @Description: 
    * @Param null  param desc
    * @Return: 
    */
    @Select("SELECT * FROM ch_user WHERE loginName = #{loginName}")
    User queryUserByLoginName(@Param("loginName") String loginName);

    /**
    * @Author:小小小阿曦
    * @Date: 14:38-2017/12/22
    * @Description: 查询所有白名单用户信息
     * @Param listState  黑白名单状态
    * @Return: List<User>
    */
    @Select({"<script>" ,
            "SELECT * FROM ch_user WHERE listState=#{listState}",
                "<if test='start!=null and len!=null'> limit #{start},#{len}</if>",
            "</script>"
            })
    List<User> queryAllUser(@Param("listState") int listState, @Param("start") int start, @Param("len") int len);

    /**
    * @Author:小小小阿曦
    * @Date: 18:13-2017/12/22
    * @Description:  通过id删除指定用户
     * @Param id  param desc
    * @Return: void
    */
    @Delete("DELETE FROM ch_user WHERE id =#{id}")
    void deleteUserById(int id);

    /**
    * @Author:小小小阿曦
    * @Date: 14:40-2017/12/22
    * @Description: 添加用户
     * @Param user  param desc
    * @Return: int
    */
    @Insert({"<script>",
            "INSERT INTO ch_user",
            "<set>",
            "<if test='loginName!=null'>loginName=#{loginName},</if>",
            "<if test='password!=null'>password=#{password},</if>",
            "<if test='niceName!=null'>niceName=#{niceName},</if>",
            "<if test='openId!=null'>openId=#{openId},</if>",
            "<if test='regTime!=null'>regTime=#{regTime},</if>",
            "<if test='headUrl!=null'>headUrl=#{headUrl}</if>",
            "</set>",
            "</script>"})
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertByUser(User user);

    /**
    * @Author:小小小阿曦
    * @Date: 18:12-2017/12/22
    * @Description: 根据用户openid获取用户信息
     * @Param openid  param desc
    * @Return: User
    */
    @Select("SELECT * FROM ch_user WHERE openid = #{openid}")
    User queryUserByOpenId(String openid);

    /**
    * @Author:小小小阿曦
    * @Date: 18:22-2017/12/22
    * @Description: 修改用户token
     * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_user SET token=#{token} WHERE id=#{id}")
    void updateTokenById(@Param("id") int id, @Param("token") String token);

    /**
    * @Author:小小小阿曦
    * @Date: 17:22-2017/12/24
    * @Description: 根据用户id获取用户信息
     * @Param null  param desc
    * @Return:
    */
    @Select("SELECT * FROM ch_user WHERE id = #{id}")
    User queryUserById(int id);

    /**
    * @Author:小小小阿曦
    * @Date: 17:23-2017/12/24
    * @Description: 修改用户密码
     * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_user set password=#{psw} WHERE id=#{uid}")
    void updatePswById(@Param("uid") int uid, @Param("psw") String psw);

    /**
    * @Author:小小小阿曦
    * @Date: 11:59-2017/12/29
    * @Description: 获取最后一个用户
     * @Param null  param desc
    * @Return:
    */
    @Select("SELECT id FROM ch_user LAST_INSERT_ID()")
    int queryLastUser();

    /**
    * @Author:小小小阿曦
    * @Date: 11:58-2018/1/2
    * @Description: 根据状态获取总条数
     * @Param null  param desc
    * @Return:
    */
    @Select({"<script>",
            "SELECT COUNT(id) FROM ch_user WHERE state=#{state} " ,
                "<when test='name!=null'>" ,
                    "AND niceName LIKE CONCAT(CONCAT('%',#{name}),'%')" ,
                "</when>" ,
                " AND listState=#{listState}",
            "</script>"})
    Integer getCountOfPlayer(@Param("state") int state, @Param("name") String name, @Param("listState") int listState);

    /**
    * @Author:小小小阿曦
    * @Date: 13:28-2018/1/2
    * @Description: 修改用户禁用状态
    * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_user SET state=#{state} WHERE id=#{id}")
    void updateUserState(@Param("state") int state, @Param("id") int id);

    /**
    * @Author:小小小阿曦
    * @Date: 13:29-2018/1/2
    * @Description: 修改用户禁言状态
     * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_user SET speakState=#{state} WHERE id=#{id}")
    void updateUserSpeakState(@Param("state") int state, @Param("id") int id);

    /**
    * @Author:小小小阿曦
    * @Date: 15:10-2018/1/2
    * @Description: 通过登录名搜索用户
     * @Param listState  黑/白名单状态
    * @Return:
    */
    @Select({"<script>",
            "SELECT * FROM ch_user WHERE listState=#{listState} AND state=#{state} AND niceName LIKE CONCAT(CONCAT('%',#{name}),'%')",
                "<if test='start!=null and len!=null'>",
                    "limit #{start},#{len}",
                "</if>",
            "</script>"})
    List<User> queryPlayersByNiceName(@Param("name") String name, @Param("start") int start, @Param("len") int len, @Param("state") int state, @Param("listState") int listState);

    /**
    * @Author:小小小阿曦
    * @Date: 15:19-2018/1/2
    * @Description: 修改用户昵称和头像
    * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_user SET headUrl=#{headUrl}, niceName=#{niceName} WHERE id=#{id}")
    void updateUserInfo(@Param("headUrl") String headUrl, @Param("niceName") String niceName, @Param("id") int id);
    
    /**
    * @Author:小小小阿曦
    * @Date: 14:17-2018/1/3
    * @Description: 统计总条数（根据状态）
     * @Param null  param desc 
    * @Return: 
    */
    @Select({"<script>",
            "SELECT COUNT(id) FROM ch_user" ,
                "<where>",
                    "<when test='type==1'>" ,
                        "state=2 and listState=#{listState}" ,
                    "</when>" ,
                    "<when test='type==2'>" ,
                         "speakState=2 and listState=#{listState}" ,
                    "</when>" ,
                "</where>" ,
            "</script>"})
    Integer getCountOfPlayerByType(@Param("type") int type, @Param("listState") int listState);

    /**
    * @Author:小小小阿曦
    * @Date: 14:18-2018/1/3
    * @Description: 根据状态查询用户列表
     * @Param null  param desc
    * @Return:
    */
    @Select({"<script>",
            "SELECT * FROM ch_user" ,
                "<where>",
                    "<when test='type==1'>" ,
                        "state=2 and listState=1" ,
                        "<if test='start!=null and len!=null'>",
                             "limit #{start},#{len}",
                        "</if>",
                    "</when>" ,
                    "<when test='type==2'>" ,
                        "speakState=2 and listState=1" ,
                        "<if test='start!=null and len!=null'>",
                            "limit #{start},#{len}",
                        "</if>",
                    "</when>" ,
                "</where>" ,
            "</script>"})
    List<User> queryPlayersByType(@Param("type") int type, @Param("start") int start, @Param("len") int len);

    /**
    * @Author:小小小阿曦
    * @Date: 23:58-2018/1/3
    * @Description: 根据QQ openId 获取用信息
    * @Param null  param desc
    * @Return:
    */
    @Select("SELECT * FROM ch_user WHERE qq_openId =#{qq_openId}")
    User queryUserByQQopenId(@Param("qq_openId") String qq_openId);

    /**
    * @Author:小小小阿曦
    * @Date: 11:31-2018/1/12
    * @Description: 修改用户黑名单状态
     * @Param null  param desc
    * @Return:
    */
    @Update("UPDATE ch_user SET listState=#{listState} WHERE id=#{id}")
    void updateUserListState(@Param("listState") int listState, @Param("id") int id);
}
