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

<div  style="color: red"> 
 		<% if ((String)request.getParameter("message") != null ){%>
 			 <%= request.getParameter("message") %>
 		<%}%> 
 </div>
<h2><fmt:message key="login.title"/></h2><br/>
<form:form action="${pageContext.request.contextPath}/prescriptionDetails.html" 
	method="POST" modelAttribute="chemistSearch">
	<table class="table">
		<tr>
			<td class="tdLabel">
				<fmt:message key="login.au360id.title"/>:
			</td>
			<td>
						<form:input id="au360id" path="au360id"/>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="login.upn.title"/>:
			</td>
			<td>
						<form:input id="upn" path="upn"/>
			</td>
		</tr>
		<tr>
		
	</table>
	<p>
		<input class="button" id="save" type="submit" value="Get Prescription"/>
	</p>
</form:form>
</body>
</html>