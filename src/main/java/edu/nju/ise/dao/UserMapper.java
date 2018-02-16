package edu.nju.ise.dao;

import edu.nju.ise.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Hermit
 * @version 2018/02/13
 *
 * @see User
 * */
@Repository
public interface UserMapper {

    /**
     * 根据用户名（微信id）查询用户信息
     *
     * @param username 用户名（微信id）
     *
     * @return 用户验证相关信息
     * */
    User findByUsername(@Param("username") final String username);

    /**
     * 插入新的用户信息
     *
     * @param user 用户信息，主键会在插入后包含在user中
     *
     * @return 插入条数
     * */
    Integer insert(User user);
}
