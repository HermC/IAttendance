package edu.nju.ise.dao;

import edu.nju.ise.model.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Hermit
 * @version 1.0 2018/02/15
 *
 *
 * @see edu.nju.ise.interceptor.dao.MybatisPageInterceptor 分页过滤器
 * */
@Repository
public interface DepartmentMapper {

    Department findDepartmentByName(@Param("name") final String name);

    /**
     * 根据筛选条件和当前页数、每页条数查询部门列表
     *
     * @param filters 筛选条件
     * @param currentPage 当前页数
     * @param pageSize 每页条数
     *
     * @return 部门列表
     * */
    List<Department> findDepartmentListByPage(@Param("filters") Map<String, Object> filters,
                                              @Param("currentPage") Long currentPage,
                                              @Param("pageSize") Long pageSize);
    /**
     * 根据筛选条件计算部门数目
     *
     * @param filters 筛选条件
     *
     * @return 部门数目
     * */
    Long countDepartment(@Param("filters") Map<String, Object> filters);

    /**
     * 新增部门
     *
     * @param department 部门信息
     *
     * @return 新增条数
     * */
    Integer insert(Department department);
}
