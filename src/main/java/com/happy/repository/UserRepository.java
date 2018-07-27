package com.happy.repository;

import com.happy.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: Administrator
 * @CreateDate: 22:21 2018/7/27
 */
public interface UserRepository extends CrudRepository<User,Long>{
}
