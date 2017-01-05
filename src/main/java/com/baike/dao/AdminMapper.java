package com.baike.dao;

import com.baike.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin login(@Param("name") String userName, @Param("password") String password);

    /**
     * @param map
     * @return集合
     */
    public List<Admin> find(Map<String, Object> map);


    /**
     * 获取总记录数
     * @param map
     * @return获取的total数
     */
    public Long getTotal(Map<String, Object> map);



    /**
     * 通过用户名查询角色信息
     * @param name
     * @return
     */
    public Set<String> getRoles(@Param("name") String name);

    /**
     * 通过用户名查询权限信息
     * @param name
     * @return
     */
    public Set<String> getPermissions(@Param("name") String name);

}