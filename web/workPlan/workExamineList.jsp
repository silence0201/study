<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:09
  工作信息列表
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考核列表</title>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="workList.action">首页</a><span class="crumb-step">&gt;</span>
                <a class="crumb-name" href="workList.action">工作计划</a><span class="crumb-step">&gt;</span>
                <span>考核列表</span></div>
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
                <a class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>地点</th>
                            <th>标题</th>
                            <th>人数</th>
                            <th>最低工时</th>
                            <th>工资</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${requestScope.works}" var="work" >
                            <tr>
                                <td>${work.workPlace}</td>
                                <td>${work.workTitle}</td>
                                <td>${work.workPersonNum}</td>
                                <td>${work.workHour}</td>
                                <td>${work.workSalary}</td>
                                <td>${work.startTime}</td>
                                <td>${work.endTime}</td>
                                <td>
                                    <a class="link-update" href="initWorkExamine.action?workId=${work.workId}">考核详情</a>
                                </td>
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
