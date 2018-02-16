package edu.nju.ise.service;

import edu.nju.ise.model.User;

import java.util.List;

/**
 * 用户验证接口，用于企业用户在该系统的注册和验证
 *
 * @author Hermit
 * @version 1.0 2018/02/13
 *
 * @see User
 * */
public interface AuthService {

    /**
     * 用户注册接口，给出用户信息和用户权限
     *
     * @param userToAdd 用户信息，包含username和password
     * @param authorities 给予用户的权限
     *
     * @return 用户信息
     *
     * @see User
     * */
    User register(User userToAdd, List<String> authorities);

    /**
     * 用户登录接口，使用用户名和密码登录
     *
     * @param username 用户名
     * @param password 密码（未经加密）
     *
     * @return 用户认证token字符串
     * */
    String login(String username, String password);

    /**
     * token刷新接口，用于更新用户持有的token
     *
     * @param oldToken 当前用户持有token
     *
     * @return 用户新的token
     * */
    String refresh(String oldToken);
}
