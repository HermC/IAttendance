<%--
  Created by IntelliJ IDEA.
  User: Hermit
  Date: 2018/2/14
  Time: 16:19
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<header class="main-header">
    <a href="<c:url value="/admin/enterprise/department"/>" class="logo">
        <%-- 缩小侧边栏后图标 --%>
        <span class="logo-mini">QA</span>
        <%-- 正常宽度标题、图标 --%>
        <span class="logo-lg"><b>标准院</b>企业管理</span>
    </a>
    <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle Navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="<c:url value="/lib/adminlte/dist/img/user2-160x160.jpg"/>"
                             class="user-image" alt="User Image">
                        <span class="hidden-xs">Administrator</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <img src="<c:url value="/lib/adminlte/dist/img/user2-160x160.jpg"/>"
                                 class="img-circle" alt="User Image">
                            <p>
                                Administrator
                            </p>
                        </li>
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">修改信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">用户登出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<aside class="main-sidebar">
    <section class="sidebar" style="height: auto">
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<c:url value="/lib/adminlte/dist/img/user2-160x160.jpg"/>"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Administrator</p>
            </div>
        </div>
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">主菜单</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-institution"></i>&nbsp;
                    <span>企业管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-briefcase"></i>&nbsp;部门管理
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-user-o"></i>&nbsp;员工管理
                        </a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-calendar"></i>&nbsp;
                    <span>考勤管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-key"></i>&nbsp;签到规则
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-folder"></i>&nbsp;考勤科目
                        </a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-calendar-minus-o"></i>&nbsp;
                    <span>请假管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-bars"></i>&nbsp;请假规则
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-sort-amount-desc"></i>&nbsp;审核流程
                        </a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-file-excel-o"></i>&nbsp;
                    <span>报表管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-line-chart"></i>&nbsp;条件查询统计
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-area-chart"></i>&nbsp;月考勤统计
                        </a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-server"></i>&nbsp;
                    <span>系统管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-key"></i>&nbsp;权限管理
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/enterprise/department"/>">
                            &nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;角色管理
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
<script>
    var focus_treeview = ${param.focus != null ? param.focus : 0};
    var focus_treeviewmenu = ${param.focusmenu != null ? param.focusmenu : 0};
    var treeview_list = document.querySelectorAll('.sidebar-menu > .treeview');
    treeview_list[focus_treeview].setAttribute('class', 'active');
    var treeviewmenu_list = treeview_list[focus_treeview].querySelectorAll('.treeview-menu > li');
    treeviewmenu_list[focus_treeviewmenu].setAttribute('class', 'active');
</script>
