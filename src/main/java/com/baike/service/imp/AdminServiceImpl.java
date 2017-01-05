package com.baike.service.imp;

import com.baike.dao.AdminMapper;
import com.baike.model.Admin;
import com.baike.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/5/005.
 */
@Service
public class AdminServiceImpl implements AdminService{


    @Resource
    private AdminMapper adminMapper;
    /**
     * 登陆
     * @param admin
     * @return
     */
    public Admin login(Admin admin) {
        String name = admin.getAdminName();
        String password = admin.getPassword();
        return adminMapper.login(name,password);
    }

    public List<Admin> find(Map<String, Object> map) {
        return adminMapper.find(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return adminMapper.getTotal(map);
    }

    public int update(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public Set<String> getRoles(String name) {
        return adminMapper.getRoles(name);
    }

    public Set<String> getPermissions(String name) {
        return adminMapper.getPermissions(name);
    }

}
