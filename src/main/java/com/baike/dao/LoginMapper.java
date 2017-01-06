package com.baike.dao;

import com.baike.model.Register;
import com.baike.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by huanghaojian on 17/1/5.
 */
@Repository
public interface LoginMapper {
    public User login(@Param("userName") String userName, @Param("password") String password);
    int register(Register register);
    int updatePassword(@Param("userId") int userId, @Param("password") String password);
    int duplicateNameChecking(String userName);
    int duplicateEmailChecking(String userEmail);
}

