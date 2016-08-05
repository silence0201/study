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
    <title>工作信息列表</title>
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
                <span class="crumb-step">&gt;</span><span class="crumb-name">工作计划</span></div>
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
                        <a href="initAddWorkPlan.action"><i class="icon-font"></i>新增计划</a>
                    </div>
                </div>
                <a class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>地点</th>
                            <th>标题</th>
                            <th>剩余人数</th>
                            <th>最低工时</th>
                            <th>工资</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>状态</th>
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
                                    <td>${work.workState}</td>
                                    <c:if test="${work.workState.equals('空')}">
                                        <td>
                                            <a class="link-update" href="initModifyWorkPlan.action?workId=${work.workId}">修改</a>
                                            <a class="link-update" href="initWorkDistribution.action?workId=${work.workId}">分配</a>
                                            <a class="link-update" href="deleteWork.action?workId=${work.workId}">删除</a>
                                        </td>
                                    </c:if>

                                <c:if test="${work.workState.equals('未满')}" >
                                    <td>
                                        <a class="link-update" href="workDistributionInfo.action?workId=${work.workId}">详情</a>
                                        <a class="link-update" href="initWorkDistribution.action?workId=${work.workId}">分配</a>
                                    </td>
                                </c:if>

                                <c:if test="${work.workState.equals('已满')}">
                                    <td>
                                        <a class="link-update" href="workDistributionInfo.action?workId=${work.workId}">详情</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>

                        <%--<tr>--%>
                            <%--<td>第一食堂</td>  <!--标签ID-->--%>
                            <%--<td>擦桌子</td>--%>
                            <%--<td>5</td>--%>
                            <%--<td>20</td>--%>
                            <%--<td>20</td>--%>
                            <%--<td>9点</td> <!--标签名称-->--%>
                            <%--<td>11点</td> <!--标签名称-->--%>
                            <%--<td>未满</td><!-- 未分配的操作显示修改和分配 -->--%>
                            <%--<td>--%>
                                <%--<a class="link-update" href="workPlanModify.jsp">修改</a>--%>
                                <%--<a class="link-update" href="workPlanDistribution.jsp">分配</a>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td>科技馆</td>  <!--标签ID-->--%>
                            <%--<td>值班</td>--%>
                            <%--<td>5</td>--%>
                            <%--<td>20</td>--%>
                            <%--<td>20</td>--%>
                            <%--<td>下午3点</td> <!--标签名称-->--%>
                            <%--<td>下午5点</td> <!--标签名称-->--%>
                            <%--<td>已满</td>--%>
                            <%--<td>--%>
                                <%--<a class="link-update" href="workPlanDistribution.jsp">详情</a>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td>图书馆</td>  <!--标签ID-->--%>
                            <%--<td>搬书</td>--%>
                            <%--<td>5</td>--%>
                            <%--<td>20</td>--%>
                            <%--<td>20</td>--%>
                            <%--<td>下午3点</td> <!--标签名称-->--%>
                            <%--<td>下午5点</td> <!--标签名称-->--%>
                            <%--<td>已结束</td>--%>
                            <%--<td>--%>
                                <%--<a class="link-del" href="#">删除</a>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                    </table>
                    <a href="workContractList.action"> <input class="btn btn-primary btn6 mr10" value="合同" type="button"></a>
                    <a href="workExamineList.action"> <input class="btn btn-primary btn6 mr10" value="考核" type="button"></a>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
