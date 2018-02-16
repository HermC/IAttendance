<%--
  Created by IntelliJ IDEA.
  User: Hermit
  Date: 2018/2/16
  Time: 17:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../stylesheets.jsp"/>
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
                    <a href="<c:url value="/admin/enterprise/department"/>">
                        <i class="fa fa-institution"></i>
                        企业管理
                    </a>
                </li>
                <li class="active">
                    <a href="<c:url value="/admin/enterprise/department"/>">
                        <i class="fa fa-briefcase"></i>
                        部门管理
                    </a>
                </li>
                <li class="active">
                    <a href="#">
                        <i class="fa fa-briefcase"></i>
                        新增部门
                    </a>
                </li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">创建</h3>
                            <div class="box-tools">
                                <div class="btn-group pull-right">
                                    <a href="<c:url value="/admin/enterprise/department"/>"
                                        class="btn btn-sm btn-default">
                                        <i class="fa fa-arrow-left"></i>
                                        &nbsp;返回
                                    </a>
                                </div>
                            </div>
                        </div>
                        <form id="department_new_form" class="form-horizontal">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="name">部门名称</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="fa fa-pencil"></i>
                                            </span>
                                            <input type="text" name="name" id="name"
                                                   class="form-control" placeholder="部门名称">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2"></label>
                                    <div class="col-sm-8">
                                        <button type="button" id="department_new_submit"
                                                class="btn btn-success">提交</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<jsp:include page="../scripts.jsp"/>
<script type="text/javascript" rel="script" src="<c:url value="/js/admin/enterprise/department-new.js"/>"></script>
</body>
</html>
