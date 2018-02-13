package edu.nju.ise.dao;

import edu.nju.ise.model.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityMapper {

    public List<Authority> findById(@Param("id") final Long id);
}
