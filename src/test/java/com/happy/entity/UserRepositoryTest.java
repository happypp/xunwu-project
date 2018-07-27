package com.happy.entity;

import com.happy.ApplicationTests;
import com.happy.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Administrator
 * @CreateDate: 22:23 2018/7/27
 */
public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);

        Assert.assertEquals("wali",user.getName());


    }



}
