package edu.nju.ise.dao;

import edu.nju.ise.model.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Hermit
 * @version 1.0 2018/02/14
 * */
public interface AuthorityMapper {

    /**
     * 根据用户ID查找用户权限
     *
     * @param id 用户id（自增主键）
     *
     * @return 用户权限列表
     * */
    List<Authority> findById(@Param("id") final Long id);

    /**
     * 插入用户权限
     *
     * @param authorities 用户权限列表
     *
     * @return 插入行数
     * */
    Integer insert(@Param("authorities") List<Authority> authorities);

}
