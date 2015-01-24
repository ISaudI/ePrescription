<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<title> Login</title>
</head>
<body>
<fmt:setBundle basename="resources.eprescription-resources"/>
<p>
	<c:if test='${login.au360Id != null}'>
		<a class="button" href="${pageContext.request.contextPath}/selectLogin.html?au360id=${login.au360Id}&"><fmt:message key="navigation.back"/></a>
	</c:if>
	<c:if test='${login.au360Id == null}'>
		<a class="button" href="${pageContext.request.contextPath}/indexLogin.html"><fmt:message key="navigation.back"/></a>
	</c:if>
</p>
<div  style="color: red"> 
 		<% if ((String)request.getParameter("message") != null ){%>
 			 <%= request.getParameter("message") %>
 		<%}%> 
 </div>
<h2><fmt:message key="login.title"/></h2><br/>
<form:form action="${pageContext.request.contextPath}/verifyLogin.html" 
	method="POST" modelAttribute="login">
	<table class="table">
		<tr>
			<td class="tdLabel">
				<fmt:message key="login.au360id.title"/>:
			</td>
			<td>
						<form:input id="au360id" path="au360Id"/>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="login.password.title"/>:
			</td>
			<td>
						<form:input id="password" path="password"/>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="login.role.title"/>:
			</td>
			<td>
			       <form:select path="role">
			           <form:option value="doctor">Doctor</form:option>
			           <form:option value="Patient">Patient</form:option>
			           <form:option value="Chemist">Chemist</form:option>
			       </form:select>
						
			</td>
		</tr>
	</table>
	<p>
		<input class="button" id="save" type="submit" value="Login"/>
	</p>
</form:form>
</body>
</html>