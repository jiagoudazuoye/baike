package com.baike.service.imp;

import com.baike.dao.UserMapper;
import com.baike.model.User;
import com.baike.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiechur on 2016/8/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    public User findById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> selectAll() {
        return null;
    }

    public int add(User user) {
        return 0;
    }

    public int update(User user) {
        return 0;
    }

    public int updateImage(Integer userId, String userImage) {
        return 0;
    }

    public List<User> find(Map<String, Object> map) {
        return null;
    }

    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    public int delete(Integer userId) {
        return 0;
    }

    public User findByName(String userName) {
        return null;
    }

    //用户修改信息
    public int userUpdate(Integer userId, Integer age, String sex, String password) {
        User user=userMapper.selectByPrimaryKey(userId);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        return userMapper.userUpdateInfo(user);
    }

}
