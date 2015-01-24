<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<title>View Doctor</title>
</head>
<body>
<fmt:setBundle basename="resources.eprescription-resources"/>
	<p>
		<a class="button" href="${pageContext.request.contextPath}/indexDoctor.html"><fmt:message key="navigation.back"/></a>
	</p>
	<h2><fmt:message key="doctor.title"/></h2><br/>
		
	<table>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.doctorid.title"/>:
			</td>
			<td>
						${doctor.doctorId}
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.doctorname.title"/>:
			</td>
			<td>
						${doctor.doctorName}
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.aa360id.title"/>:
			</td>
			<td>
						${doctor.aa360id}
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.phoneno.title"/>:
			</td>
			<td>
						${doctor.phoneNo}
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.emailid.title"/>:
			</td>
			<td>
						${doctor.emailId}
			</td>
		</tr>
		<tr>
			<td class="tdLabel">
				<fmt:message key="doctor.password.title"/>:
			</td>
			<td>
						${doctor.password}
			</td>
		</tr>
	</table>
	
				<p>
					<a class="button" href="${pageContext.request.contextPath}/newDoctorPrescription.html?doctor_doctorId=${doctor.doctorId}&"><fmt:message key="navigation.new"/> <fmt:message key="prescription.title"/></a>
				</p>
</body>
</html>