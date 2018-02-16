<%--
  Created by IntelliJ IDEA.
  User: Hermit
  Date: 2018/2/14
  Time: 16:22
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../stylesheets.jsp"/>
    <%--<style>--%>
        <%--&lt;%&ndash; 隐藏daterangepicker中的选择日期日历部分，因为仅需要选择时间范围 &ndash;%&gt;--%>
        <%--.calendar-table {--%>
            <%--display: none;--%>
        <%--}--%>
    <%--</style>--%>

    <title>南京标准院企业管理 - 部门管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%-- 给侧边栏添加class，传递需要添加focus的是第几个treeview --%>
    <jsp:include page="../header-nav.jsp">
        <jsp:param name="focus_treeview" value="0"/>
        <jsp:param name="focus_treeviewmenu" value="0"/>
    </jsp:include>
    <div class="content-wrapper" style="min-height: 916px">
        <section class="content-header">
            <h1>部门管理<small>部门列表</small></h1>
            <ol class="breadcrumb">
                <li>
                    <a href="#">
                        <i class="fa fa-dashboard"></i>
                        Home
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-institution"></i>
                        企业管理
                    </a>
                </li>
                <li class="active">
                    <a href="#">
                        <i class="fa fa-briefcase"></i>
                        部门管理
                    </a>
                </li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="department_id">部门ID</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="部门ID"
                                                       id="department_id" name="department_id">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="department_id">部门名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="部门名称"
                                                       id="department_name" name="department_name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"></label>
                                            <div class="col-sm-8">
                                                <button type="button" class="btn btn-sm btn-success"
                                                        id="department_search">搜索</button>
                                                &nbsp;
                                                <button type="reset" class="btn btn-sm btn-default"
                                                        id="department_reset">重置</button>
                                                &nbsp;
                                                <a href="<c:url value="/admin/enterprise/department/new"/>" type="button" class="btn btn-sm btn-info"
                                                        id="department_new">新增部门</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <%--<div class="form-horizontal">--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label class="col-sm-4 control-label" for="arrive_time">上班时间</label>--%>
                                            <%--<div class="col-sm-8">--%>
                                                <%--<input type="text" class="form-control" placeholder="上班时间"--%>
                                                       <%--id="arrive_time" name="arrive_time">--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label class="col-sm-4 control-label" for="leave_time">下班时间</label>--%>
                                            <%--<div class="col-sm-8">--%>
                                                <%--<input type="text" class="form-control" placeholder="下班时间"--%>
                                                       <%--id="leave_time" name="leave_time">--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <table id="department_table" class="table table-bordered table-hover dataTable"
                                   cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <td>部门ID</td>
                                        <td>部门名称</td>
                                        <td>操作</td>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../footer.jsp"/>
</div>
<jsp:include page="../scripts.jsp"/>
<script type="text/javascript" rel="script" src="<c:url value="/js/admin/enterprise/departments.js"/>"></script>
</body>
</html>