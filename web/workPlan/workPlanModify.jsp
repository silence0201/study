<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:17
  修改工作计划
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
<head>
    <title>修改工作计划</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script>
        function modifyWork() {

            var workPlace = document.getElementById("wPlace").value;

            var workTitle = document.getElementById("wTitle").value;

            var workNumber = document.getElementById("wNumber").value;
            var workSalary = document.getElementById("wSalary").value;
            var workHour = document.getElementById("wHour").value;
            var workStartTime = document.getElementById("wStartTime").value;
            var workEndTime = document.getElementById("wEndTime").value;

            if (workPlace == "" || workPlace == null || workPlace == "18") {
                alert("工作地点不能为空");
                return false;
            } else if (workTitle == "" || workTitle == null) {
                alert("主题不能为空");
                return false;
            } else if (workNumber == "" || workNumber == null){
                alert("人数不能为空");
                return false;
            }else if (workSalary == "" || workSalary == null){
                alert("工资不能为空");
                return false;
            }else if (workHour == "" || workHour == null){
                alert("最低工时不能为空");
                return false;
            }else if (workStartTime == "" || workStartTime == null){
                alert("开始时间不能为空");
                return false;
            }else if (workEndTime == "" || workEndTime == null){
                alert("结束时间不能为空");
                return false;
            }else {
                return true;
            }
        }
    </script>
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
                <span class="crumb-step">&gt;</span><a class="crumb-name" href="workList.action">工作计划</a>
                <span class="crumb-step">&gt;</span><span>修改工作</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <struts:form action="modifyWorkPlan" onsubmit="modifyWork();" method="get">
                    <input class="common-text required" id="wId" name="work_id" size="50" value="${work.workId}" type="hidden">
                    <table class="insert-tab" width="100%">
                            <tr>
                                <th width="120"><i class="require-red">*</i>地点：</th>
                                <td>
                                    <select name="work_place" id="wPlace" class="required" >
                                        <option value="${work.workPlace}">${work.workPlace}</option>
                                        <option value="第一食堂">第一食堂</option>
                                        <option value="第二食堂">第二食堂</option>
                                        <option value="第一实验室">第一实验室</option>
                                        <option value="第二实验室">第二实验室</option>
                                        <option value="图书馆前台服务处">图书馆前台服务处</option>
                                        <option value="图书馆自由阅览室">图书馆自由阅览室</option>
                                        <option value="科技馆">科技馆</option>
                                        <option value="学生活动中心">学生活动中心</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>标题：</th>
                                <td>
                                    <input class="common-text required" id="wTitle" name="work_title" size="50" value="${work.workTitle}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>人数：</th>
                                <td>
                                    <input class="common-text required" id="wNumber" name="work_person_num" size="50" value="${work.workPersonNum}" type="text">
                                </td>
                            </tr>
                        <tr>
                            <th><i class="require-red">*</i>最低工时：</th>
                            <td>
                                <input class="common-text required" id="wHour" name="work_hour" size="50" value="${work.workHour}" type="text">
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>工资：</th>
                                <td>
                                    <input class="common-text required" id="wSalary" name="work_salary" size="50" value="${work.workSalary}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>开始时间：</th>
                                <td>
                                    <input class="common-text required" id="wStartTime" name="start_time" size="50" value="${work.startTime}" type="time">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>结束时间：</th>
                                <td>
                                    <input class="common-text required" id="wEndTime" name="end_time" size="50" value="${work.endTime}" type="time">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </table>
                </struts:form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
