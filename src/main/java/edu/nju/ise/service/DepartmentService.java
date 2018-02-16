package edu.nju.ise.service;

import edu.nju.ise.model.Department;

import java.util.List;
import java.util.Map;

/**
 * 部门操作接口，用于权限用户对于企业部门信息的操作
 *
 * @author Hermit
 * @version 1.0 2018/02/16
 *
 * @see Department
 * */
public interface DepartmentService {

    /**
     * 获取企业所有部门列表，分页
     *
     * @param filters 筛选条件
     * @param currentPage 当前页数
     * @param pageSize 每页条数
     *
     * @return 部门列表
     * */
    List<Department> getDepartmentListByPage(Map<String, Object> filters,
                                             Long currentPage, Long pageSize);

    /**
     * 获取企业部门计数
     *
     * @param filters 筛选条件
     *
     * @return 部门数目
     * */
    Long countDepartment(Map<String, Object> filters);

    /**
     * 新建部门
     *
     * @param department 部门信息
     *
     * @return 新增条数
     * */
    Integer newDepartment(Department department);
}
