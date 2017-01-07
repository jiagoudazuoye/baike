package com.baike.service;

import com.baike.model.Admin;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiechur on 2016/8/21.
 */
public interface AdminService {
    //登录
    Admin login(Admin admin);

    /**
     * 查询
     * @param map
     * @return
     */
    public List<Admin> find(Map<String, Object> map);
    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);
    /**
     * 更新数据
     * @param manager
     * @return
     */
    public int update(Admin manager);

    public Set<String> getRoles(String name);

    public Set<String> getPermissions(String name);
}
