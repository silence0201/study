<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午9:52
  学生申请列表页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="/workPlan/workPlanList.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生申请</span></div>
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
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="initStudentAdd.action"><i class="icon-font"></i>新增申请</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>联系方式</th>
                            <th>第一志愿</th>
                            <th>第二志愿</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${requestScope.requests}" var="request">
                            <tr>
                                <td>${request.student.studentId}</td>
                                <td>${request.student.studentName}</td>
                                <td>${request.student.studentPhone}</td>
                                <td>${request.studentFirstChoice}</td>
                                <td>${request.studenSecondChoice}</td>
                                <td>${request.student.studentAcademy}</td>
                                <td>${request.student.studentMajor}</td>
                                <td>${request.requestStatus}</td>
                                <c:if test="${request.requestStatus.equals('未分配')}">
                                    <td>
                                        <a class="link-update" href="initModifyStudentRequest.action?studentRequestId=${request.requestId}">修改</a>
                                        <a class="link-del" href="deleteStudentRequest.action?studentRequestId=${request.requestId}">删除</a>
                                    </td>
                                </c:if>

                                <c:if test="${request.requestStatus.equals('已分配')}">
                                    <td>
                                        <a class="link-del" href="studentRequestInfo.action?studentId=${request.student.studentId}">详情</a>
                                    </td>
                                </c:if>

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
