<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>List Prescriptions</title>
</head>
<body>

<fmt:setBundle basename="resources.eprescription-resources"/>
	<p>
		<a class="button" href="${pageContext.request.contextPath}/newPrescription.html"><fmt:message key="navigation.new"/> <fmt:message key="prescription.title"/></a>
	</p>
	
	<table id="prescriptionTable">
		<thead>
		<tr>
			<th><fmt:message key="prescription.prescriptionid.title"/></th>
			<th><fmt:message key="prescription.upn.title"/></th>
			<th><fmt:message key="prescription.patientid.title"/></th>
			<th><fmt:message key="prescription.doctorid.title"/></th>
			<th><fmt:message key="prescription.status.title"/></th>
		</tr>
		</thead>
		<tbody>
	<c:forEach items="${prescriptions}" var="current" varStatus="i">
		<c:choose>
			<c:when test="${(i.count) % 2 == 0}">
		    	<c:set var="rowclass" value="tableRow1"/>
			</c:when>
			<c:otherwise>
		    	<c:set var="rowclass" value="tableRow2"/>
			</c:otherwise>
		</c:choose>			
		<tr class="${rowclass}">
			<td>
				<a href="${pageContext.request.contextPath}/selectPrescription.html?prescriptionId=${current.prescriptionId}&">${current.prescriptionId}</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/indexPrescriptionDrugRel.html?upnNumber=${current.upn}&">${current.upn}</a>		
			</td>
			<td>
						
								${current.patientId}
						
			</td>
			<td>
						
								${current.doctorId}
						
			</td>
			<td>
						
								${current.status}
						
			</td>
		</tr>
	</c:forEach>
		</tbody>
	</table>
</body>
</html>