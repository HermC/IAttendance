package edu.nju.ise.controller.admin;

import edu.nju.ise.exception.DepartmentInvalidException;
import edu.nju.ise.model.ResponseData;
import edu.nju.ise.model.TableData;
import edu.nju.ise.model.Department;
import edu.nju.ise.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作为系统管理员admin对系统进行配置的url
 *
 * @author Hermit
 * @version 1.0 2018/02/14
 * */
@Controller
@RequestMapping(value = "/admin/enterprise")
public class AdminDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取部门列表页面
     * */
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public String toDepartment() {
        return "admin/enterprise/departments";
    }

    /**
     * 获取创建部门的页面
     * */
    @RequestMapping(value = "/department/new", method = RequestMethod.GET)
    public String toDepartmentNew() {
        return "admin/enterprise/department-new";
    }

    /**
     * 根据条件查询部门列表
     * */
    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseBody
    public TableData searchDepartment(HttpServletRequest request) {
        Long start = Long.valueOf(request.getParameter("start"));
        Long pageSize = Long.valueOf(request.getParameter("length"));
        Long draw = Long.valueOf(request.getParameter("draw"));
        String departmentId = request.getParameter("department_id");
        String departmentName = request.getParameter("department_name");

        Map<String, Object> filters = new HashMap<>();
        filters.put("id", departmentId.equals("") ? null : departmentId);
        filters.put("name", departmentName.equals("") ? null : departmentName);

        Long currentPage = start / pageSize + 1;

        List<Department> departmentList
                = departmentService.getDepartmentListByPage(filters, currentPage, pageSize);
        Long countDepartment = departmentService.countDepartment(filters);

        TableData tableData = new TableData();
        tableData.setData(departmentList);
        tableData.setPageSize(pageSize);
        tableData.setRecordsTotal(countDepartment);
        tableData.setRecordsFiltered(countDepartment);
        tableData.setDraw(draw);
        tableData.setCurrentPage(currentPage);

        return tableData;
    }

    /**
     * 创建部门
     * */
    @RequestMapping(value = "/department/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData newDepartment(@RequestBody Department department) {

        return ResponseData.ok("success");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DepartmentInvalidException.class)
    public ResponseData departmentInvalid(Exception e) {
        return ResponseData.badRequest(e.getMessage());
    }
}
