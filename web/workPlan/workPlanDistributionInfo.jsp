<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:29
  分配
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分配</title>
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
                <a class="crumb-name" href="workList.action">工作计划</a><span class="crumb-step">&gt;</span>
                <span>分配</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>地点</th>
                            <th>标题</th>
                            <th>人数</th>
                            <th>最低工时</th>
                            <th>工资</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>状态</th>
                        </tr>
                                <tr>

                                    <td>${work.workPlace}</td>  <!--标签ID-->
                                    <td>${work.workTitle}</td>
                                    <td>${work.workPersonNum}</td>
                                    <td>${work.workHour}</td>
                                    <td>${work.workSalary}</td>
                                    <td>${work.startTime}</td> <!--标签名称-->
                                    <td>${work.endTime}</td> <!--标签名称-->
                                    <td>${work.workState}</td><!-- 未分配的操作显示修改和分配 -->

                                </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            分配情况
            <form name="myform" id="myform" method="post">

                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>联系方式</th>
                            <th>学院</th>
                            <th>专业</th>
                        </tr>
                        <c:forEach items="${requestScope.distributionInfo}" var="distributionInfo">
                        <tr>
                            <td>${distributionInfo.student.studentId}</td>  <!--标签ID-->
                            <td>${distributionInfo.student.studentName}</td> <!--标签名称-->
                            <td>${distributionInfo.student.studentPhone}</td>
                            <td>${distributionInfo.student.studentAcademy}</td> <!--标签名称-->
                            <td>${distributionInfo.student.studentMajor}</td> <!--标签名称-->
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
