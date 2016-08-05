<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:36
  考核记录
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考核记录</title>
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
                <a href="workList.action" color="#white">首页</a>
                <span class="crumb-step">&gt;</span>
                <a class="crumb-name" href="examineList.jsp">考核记录</a><span class="crumb-step">&gt;</span>
                <span>详细记录</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">详细记录</th>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form >

                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>日期</th>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>工时</th>
                        </tr>
                        <c:forEach items="${requestScope.examines}" var="examine">
                            <tr>
                                <td>${examine.workTime}</td>
                                <td>${examine.studentWork.student.studentId}</td>
                                <td>${examine.studentWork.student.studentName}</td>
                                <td>${examine.studentWork.student.studentAcademy}</td>
                                <td>${examine.studentWork.student.studentMajor}</td>
                                <td>${examine.examineHour}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
