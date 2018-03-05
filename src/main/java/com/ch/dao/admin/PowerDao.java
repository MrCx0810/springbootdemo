package com.ch.dao.admin;

import com.ch.entity.Admin;
import com.ch.entity.Power;
import com.ch.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/27
 * @Time: 23:45
 * To change this template use File | Settings | File Templates.
 */
@Mapper
public interface PowerDao {

    /**
     * 通过角色ID查询该角色拥有的所有权限
     * @param roleId:角色ID
     * @return List<Power>
     */
    @Select("SELECT * FROM ch_power AS p JOIN ch_powermidrole AS m ON m.powerId=p.id WHERE m.roleId=#{roleId}")
     List<Power> queryPowerByRoleId(@Param("roleId")int roleId);
    /**
     * 查询比该角色等级低的所有角色白名单用户
     * @param roleId:角色ID
     * @return List<Admin>
     */
    @Select({"<script>",
            "SELECT * FROM ch_admin WHERE roleId >= #{roleId} AND listState=1",
            "<if test='start!=null and len!=null'>",
                "limit #{start},#{len}",
            "</if>",
            "</script>"})
     List<Admin> queryAdmin(@Param("roleId")int roleId, @Param("start") int start, @Param("len") int len);
    /**
     * 获取角色信息
     */
    @Select("SELECT * FROM ch_role WHERE id >= #{roleId}")
    List<Role> queryRole(@Param("roleId") Integer roleId);
    /**
     * 通过账号查询管理员信息
     * @param:login
     * @return admin
     */
    @Select("SELECT * FROM ch_admin WHERE loginName=#{login}")
     Admin queryAdminByLogin(@Param("login")String login);
    /**
     * 添加管理员账号
     * @param admin
     * @return void
     */
    @Insert("INSERT INTO ch_admin(loginName,loginPassword,name, phoneNumber,roleName,roleId, fid) VALUES(#{loginName},#{loginPassword},#{name},#{phoneNumber},#{roleName},#{roleId},#{fid})")
     void insertAdmin(Admin admin);
    /**
     * 通过ID查询角色信息
     * @param id:角色id
     * @return Role
     */
    @Select("SELECT * FROM ch_role WHERE id=#{id}")
     Role queryRoleById(int id);
    /**
     * 通过ID更新用户的状态
     * state：禁用状态
     * list_state : 黑名单状态
     */
    @Update({"<script>" ,
            "UPDATE ch_admin",
            "<set>",
            "<if test='state!=null'>state=#{state},</if>",
            "<if test='listState!=null'>listState=#{listState}</if>",
            "</set>",
            "WHERE id=#{id}",
            "</script>"})
     void updateAdminState(@Param("id")Integer id, @Param("state")Integer state,@Param("listState") Integer listState);
    /**
     * 通过ID查询管理员信息
     */
    @Select("SELECT * FROM ch_admin WHERE id=#{id}")
     Admin queryAdminById(@Param("id")int id);
    /**
     * 更新管理员账号
     * @param admin
     * @return void
     */
    @Update({"<script>" ,
            "UPDATE ch_admin",
                "<set>",
                    "<if test='loginName!=null'>loginName=#{loginName},</if>",
                    "<if test='loginPassword!=null'>loginPassword=#{loginPassword},</if>",
                    "<if test='name!=null'>name=#{name},</if>",
                    "<if test='phoneNumber!=null'>phoneNumber=#{phoneNumber},</if>",
                    "<if test='roleName!=null'>roleName=#{roleName},</if>",
                    "<if test='roleId!=null'>roleId=#{roleId}</if>",
                "</set>",
            "Where id=#{id}",
            "</script>"})
     void updateAdminById(Admin admin);
    /**
     * 通过角色名称查询角色
     * @param roleName:角色名称
     * @return void
     */
    @Select("SELECT * FROM ch_role WHERE roleName=#{roleName}")
     Role queryRoleByRoleName(String roleName);
    /**
     * 插入新的角色
     * @param roleName：角色名称
     * @retur void
     */
    @Insert("INSERT INTO ch_role(roleName)VALUES(#{roleName})")
     void insertRole(String roleName);
    /**
     * 删除角色信息
     */
    @Delete("DELETE FROM ch_role WHERE id=#{id}")
     void delRoleById(Integer id);
    /**
     * 删除与角色相关的中间表
     */
    @Delete("DELETE FROM  ch_powermidrole WHERE roleId=#{id}")
     void delMidByRoleId(Integer id);
    /**
     * 修改角色信息
     * @param id：角色ID roleName
     * @return void
     */
    @Update({"<script>" ,
            "UPDATE ch_role",
            "<set>",
            "<if test='roleName!=null'>roleName=#{roleName}</if>",
            "</set>",
            "WHERE id=#{id}",
            "</script>"})
     void updateRoleById(@Param("id")Integer id,@Param("roleName")String roleName);
    /**
     * 为角色添加权限
     */
    @Insert("INSERT INTO ch_powermidrole(roleId,powerId)VALUES(#{roleId},#{powerId})")
     void insertMid(@Param("roleId")Integer roleId, @Param("powerId")Integer powerId);
    /**
     * 添加权限
     */
    @Insert({"<script>",
            "INSERT INTO ch_power",
               "<set>",
                   "<if test='pid!=null'>pid=#{pid},</if>",
                   "<if test='title!=null'>title=#{title},</if>",
                   "<if test='url!=null'>url=#{url},</if>",
                   "<if test='icon!=null'>icon=#{icon},</if>",
                   "<if test='description!=null'>description=#{description}</if>",
               "</set>",
           "</script>"})
     void insertPower(Power power);
}
