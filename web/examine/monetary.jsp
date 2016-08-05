<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:39
  酬金
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>酬金</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="workList.action"><i class="icon-font">&#xe008;</i>工作计划</a></li>
                        <li><a href="requestList.action"><i class="icon-font">&#xe005;</i>学生申请</a></li>
                        <li><a href="examineList.action"><i class="icon-font">&#xe006;</i>考核记录</a></li>
                        <li><a href="logoutAction.action"><i class="icon-font">&#xe017;</i>退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
                <a href="workList.action">首页</a><span class="crumb-step">&gt;</span>
                <a class="crumb-name" href="examineList.action">考核记录</a><span class="crumb-step">&gt;</span>
                <span>酬金结算</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">

                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="settle.action">

                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>联系方式</th>
                            <th>应得工资</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${requestScope.monetaries}" var="monetary">
                            <tr>
                                <td>${monetary.key.studentId}</td>
                                <td>${monetary.key.studentName}</td>
                                <td>${monetary.key.studentAcademy}</td>
                                <td>${monetary.key.studentMajor}</td>
                                <td>${monetary.key.studentPhone}</td>
                                <td>${monetary.value}</td>
                                <td><a class="link-update" href="monetaryInfo.action?studentID=${monetary.key.studentId}">详情</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input class="btn btn-primary btn6 mr10" value="打印" type="submit">
                    <input class="btn btn-primary btn6 mr10" value="结算" type="submit">
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
