package com.ch.dao.admin;

import com.ch.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/27
 * @Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
@Mapper
public interface AdminDao {

    /**
     * 通过登录名获取用户信息
     * @param loginName:登录名  psw:密码
     * @return Admin
     */
    @Select("SELECT *FROM ch_admin WHERE loginName=#{loginName}")
    Admin queryAdminByLoginName(String loginName);
    /**
     * 通过ID查询管理员用户信息
     * @param id
     * @return Admin
     */
    @Select("SELECT *FROM ch_admin WHERE id=#{id}")
    Admin queryAdminById(Integer id);

    /**
     * 查询某个id的代理商
     * @param fid 父级id
     * @param roleId 角色id
     * @param state 账号状态
     * @param str 搜索关键词
     * @return
     */
    @Select({"<script>" ,
            "SELECT * FROM ch_admin",
                "<where>",
                    "<if test='fid!=null'>fid=#{fid},</if>",
                    "<if test='roleId!=null'> and roleId=#{roleId},</if>",
                    "<if test='state!=null'> and state=#{state},</if>",
                    "<if test='listState!=null'> and listState=#{listState},</if>",
                    "<if test='str!=null'> and (loginName LIKE CONCAT(CONCAT('%',#{str}),'%') or phoneNumber = #{str})</if>",
                "</where>",
            "<if test='st!=null and len!=null'>limit #{st},#{len}</if>",
            "</script>"})
    List<Admin> queryMyAdminByFidAndRoleId(@Param("fid")int fid, @Param("roleId")int roleId, @Param("state")Integer state, @Param("str")String str, @Param("list_state") Integer list_state, @Param("st") int st, @Param("len") int len);
    /**
     * 查询某个id的代理商个数
     * @param fid 父级id
     * @param roleId 角色id
     * @param state 用户账号状态
     * @param str 搜索关键词
     * @return
     */
    @Select({"<script>" ,
                "select count(id) from ch_admin  where fid=#{fid} and roleId=#{roleId} ",
                    "<if test='state!=null'> and state =#{state},</if>" ,
                    "<if test='listState!=null'> and listState=#{listState},</if>",
                    "<if test='str!=null'> and loginName LIKE CONCAT(CONCAT('%',#{str}),'%') or phoneNumber=#{str}</if>",
            "</script>"})
    Integer getCountByFidAndRid(@Param("fid")int fid, @Param("roleId")int roleId, @Param("state")Integer state,@Param("str") String str, @Param("listState") Integer listState);

    /**
    * @Author:小小小阿曦
    * @Date: 13:20-2018/1/12
    * @Description: 根据黑白名单状态 统计人员数量
     * @Param null  param desc
    * @Return:
    */
    @Select("SELECT COUNT(id) FROM ch_admin WHERE listState=#{listState}")
    Integer getCountByListState(int listState);

    /**
    * @Author:小小小阿曦
    * @Date: 13:22-2018/1/12
    * @Description: 根据黑白名单查询 管理员名单
     * @Param null  param desc
    * @Return:
    */
    @Select({"<script>",
            "SELECT * FROM ch_admin WHERE listState=#{listState}",
            "<if test='st!=null and len!=null'>",
                "limit #{st},#{len}",
            "</if>",
            "</script>"})
    List<Admin> queryAdminsByListState(@Param("listState")int listState, @Param("st") Integer st, @Param("len") Integer len);

    /**
    * @Author:小小小阿曦
    * @Date: 14:21-2018/1/12
    * @Description: 根据以管理员id删除
     * @Param null  param desc
    * @Return:
    */
    @Delete("DELETE FROM ch_admin WHERE id=#{id}")
    void deleteAdminById(Integer id);
    /**
    * @Author:小小小阿曦
    * @Date: 18:06-2018/1/13
    * @Description: 统计管理员黑/白名单 数量
     * @Param null  param desc
    * @Return:
    */
    @Select("SELECT COUNT(id) FROM ch_admin WHERE listState=#{listState}")
    Integer getCountAdminNum(int listState);


}
