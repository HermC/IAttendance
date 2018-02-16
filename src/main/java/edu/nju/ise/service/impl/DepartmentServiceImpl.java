package edu.nju.ise.service.impl;

import edu.nju.ise.dao.DepartmentMapper;
import edu.nju.ise.exception.DepartmentInvalidException;
import edu.nju.ise.model.Department;
import edu.nju.ise.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 部门操作接口实现类
 *
 * @author Hermit
 * @version 1.0 2018/02/15
 * */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartmentListByPage(Map<String, Object> filters, Long currentPage, Long pageSize) {
        return departmentMapper.findDepartmentListByPage(filters, currentPage, pageSize);
    }

    @Override
    public Long countDepartment(Map<String, Object> filters) {
        return departmentMapper.countDepartment(filters);
    }

    @Override
    public Integer newDepartment(Department department) {
        if (departmentMapper.findDepartmentByName(department.getName()) != null) {
            throw new DepartmentInvalidException("部门已经存在");
        }
        return departmentMapper.insert(department);
    }
}
