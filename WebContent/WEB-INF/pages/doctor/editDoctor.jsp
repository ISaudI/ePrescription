<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<title>Edit Doctor</title>
</head>
<body>
<fmt:setBundle basename="resources.eprescription-resources"/>
<p>
	<c:if test='${doctor.doctorId != null}'>
		<a class="button" href="${pageContext.request.contextPath}/selectDoctor.html?doctorId=${doctor.doctorId}&"><fmt:message key="navigation.back"/></a>
	</c:if>
	<c:if test='${doctor.doctorId == null}'>
		<a class="button" href="${pageContext.request.contextPath}/indexDoctor.html"><fmt:message key="navigation.back"/></a>
	</c:if>
</p>

<h2><fmt:message key="doctor.title"/></h2><br/>
<form:form action="${pageContext.request.contextPath}/saveDoctor.html" 
	method="POST" modelAttribute="doctor">
	<table class="table">
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.doctorid.title"/>:
			</td>
			<td>
						<form:input id="doctorId" path="doctorId"/>
						<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "doctorId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="doctor.doctorid.help"/>", constraints : {places:0}}})); </script>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.doctorname.title"/>:
			</td>
			<td>
						<form:input id="doctorName" path="doctorName"/>
						<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "doctorName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="doctor.doctorname.help"/>"}})); </script>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.aa360id.title"/>:
			</td>
			<td>
						<form:input id="aa360id" path="aa360id"/>
						<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "aa360id",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="doctor.aa360id.help"/>"}})); </script>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.phoneno.title"/>:
			</td>
			<td>
						<form:input id="phoneNo" path="phoneNo"/>
						<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "phoneNo",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="doctor.phoneno.help"/>"}})); </script>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.emailid.title"/>:
			</td>
			<td>
						<form:input id="emailId" path="emailId"/>
						<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "emailId",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="doctor.emailid.help"/>"}})); </script>
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.password.title"/>:
			</td>
			<td>
						<form:input id="password" path="password"/>
						<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "password",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="doctor.password.help"/>"}})); </script>
			</td>
		</tr>
	</table>
	<p>
		<input class="button" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
	</p>
</form:form>
</body>
</html>