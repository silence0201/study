<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午9:52
  学生申请列表页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生申请列表</title>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="workList.action">首页</a>
                <span class="crumb-step">&gt;</span><a href="requestList.action">学生申请</a>
                <span class="crumb-step">&gt;</span>
                <span class="crumb-name">学生工作详情</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">学生工作详情</th>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>工作地点</th>
                            <th>工作内容</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                        </tr>
                        <c:forEach items="${requestScope.requestInfo}" var="requestInfo">
                            <tr>
                                <td>${requestInfo.student.studentId}</td>  <!--标签ID-->
                                <td>${requestInfo.student.studentName}</td> <!--标签名称-->
                                <td>${requestInfo.work.workPlace}</td> <!--标签名称-->
                                <td>${requestInfo.work.workTitle}</td>
                                <td>${requestInfo.work.startTime}</td> <!--标签名称-->
                                <td>${requestInfo.work.endTime}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
