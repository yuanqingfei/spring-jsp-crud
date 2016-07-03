<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>专家页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	增加一位新专家
</h1>

<c:url var="addAction" value="/experts/add" ></c:url>

<form:form action="${addAction}" modelAttribute="expert">
<table>
	<c:if test="${!empty expert.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="编号"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td>
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="姓名"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="title">
				<spring:message text="职称"/>
			</form:label>
		</td>
		<td>
			<form:input path="title" />
		</td>
	</tr>

	<tr>
		<td>
			<form:label path="department">
				<spring:message text="科室"/>
			</form:label>
		</td>
		<td>
			<form:input path="department" />
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty expert.name}">
				<input type="submit"
					value="<spring:message text="修改专家信息"/>" />
			</c:if>
			<c:if test="${empty expert.name}">
				<input type="submit"
					value="<spring:message text="增加新专家"/>" />
			</c:if>
		</td>
	</tr>
</table>
</form:form>
<br>
<h3>专家列表</h3>
<c:if test="${!empty listExperts}">
	<table class="tg">
	<tr>
		<th width="80">编号</th>
		<th width="120">姓名</th>
		<th width="120">职称</th>
		<th width="120">科室</th>
		<th width="60">编辑</th>
		<th width="60">删除</th>
	</tr>
	<c:forEach items="${listExperts}" var="expert">
		<tr>
			<td>${expert.id}</td>
			<td>${expert.name}</td>
			<td>${expert.title}</td>
			<td>${expert.department}</td>
			<td><a href="<c:url value='/experts/edit/${expert.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/experts/remove/${expert.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
