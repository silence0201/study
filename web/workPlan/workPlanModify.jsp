<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:17
  修改工作计划
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改工作计划</title>
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
                        <li><a href="workPlanList.jsp"><i class="icon-font">&#xe008;</i>工作计划</a></li>
                        <li><a href="/studentReqest/studentRequestList.jsp"><i class="icon-font">&#xe005;</i>学生申请</a></li>
                        <li><a href="/examine/examineList.jsp"><i class="icon-font">&#xe006;</i>考核记录</a></li>
                        <li><a href=""><i class="icon-font">&#xe017;</i>退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="workPlanList.jsp">首页</a>
                <span class="crumb-step">&gt;</span><a class="crumb-name" href="workPlanList.jsp">工作计划</a>
                <span class="crumb-step">&gt;</span><span>修改工作</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form >
                    <table class="insert-tab" width="100%">
                        <tr>
                            <th width="120"><i class="require-red">*</i>地点：</th>
                            <td>
                                <select name="colId" id="catid" class="required">
                                    <option value="18">请选择</option>
                                    <option value="19">第一食堂</option>
                                    <option value="20">第二食堂</option>
                                    <option value="21">第一实验室</option>
                                    <option value="22">第二实验室</option>
                                    <option value="23">图书馆前台服务处</option>
                                    <option value="24">图书馆自由阅览室</option>
                                    <option value="25">科技馆</option>
                                    <option value="26">学生活动中心</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>标题：</th>
                            <td>
                                <input class="common-text required"  name="title" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>时间：</th>
                            <td>
                                <input class="common-text required"  name="title" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>人数：</th>
                            <td>
                                <input class="common-text required"  name="title" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>工时：</th>
                            <td>
                                <input class="common-text required"  name="title" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>工资：</th>
                            <td>
                                <input class="common-text required" name="title" size="50" value="" type="text">
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
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
