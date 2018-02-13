package edu.nju.ise.dao;

import edu.nju.ise.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public User findByUsername(@Param("username") final String username);
}
