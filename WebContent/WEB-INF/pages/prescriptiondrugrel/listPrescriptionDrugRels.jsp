<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>List PrescriptionDrugRels</title>
<script type="text/javascript">
var IdValuesArray = [];
$(document).ready(function(){
	 
});


</script>
</head>
<body>

<fmt:setBundle basename="resources.eprescription-resources"/>
	<p>
		<a class="button" href="${pageContext.request.contextPath}/newPrescriptionDrugRel.html"><fmt:message key="navigation.new"/> <fmt:message key="prescriptiondrugrel.title"/></a>
	</p>
	Role : ${role}
	<table id="prescriptiondrugrelTable">
		<thead>
		<tr>
			<th><fmt:message key="prescriptiondrugrel.presdrugrelid.title"/></th>
			<th><fmt:message key="prescriptiondrugrel.presdrugrelupn.title"/></th>
			<th><fmt:message key="prescriptiondrugrel.presdrugreldrugid.title"/></th>
			<th><fmt:message key="prescriptiondrugrel.presdrugreldosage.title"/></th>
			<th><fmt:message key="prescriptiondrugrel.presdrugrelfrequency.title"/></th>
			<th><fmt:message key="prescriptiondrugrel.presdrugrelstatus.title"/></th>
			<th>&nbsp;</th>
		</tr>
		</thead>
		<tbody>
	<c:forEach items="${prescriptiondrugrels}" var="current" varStatus="i">
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
				<a href="${pageContext.request.contextPath}/selectPrescriptionDrugRel.html?presDrugRelId=${current.presDrugRelId}&">${current.presDrugRelId}</a>
			</td>
			<td>
						
								${current.upn}
						
			</td>
			<td>
						
								${current.drugName}
						
			</td>
			<td>
						
								${current.dosage}
						
			</td>
			<td>
						
								${current.frequency}
						
			</td>
			<td>
						
								${current.status}
						
			</td>
			<td>
						
							<c:if test="${role == 'Chemist' && current.status == 'To Deliver' }">
							  <input  type="checkbox" value="${current.presDrugRelId}" onclick="updateRelValues(this)">
							
							</c:if>
						
			</td>
		</tr>
	</c:forEach>
		</tbody>
	</table>
	<c:if test="${role == 'Chemist'}">
		<form action="./prescriptionStatusChange.html">
	   		<input type="hidden" id="drugPresId" name="drugPresId"> 
	   		<input type="hidden" id="upnNumber" name="upnNumber" 
	   								value="${upnNumber}"> 
	   	    <input type="hidden" id="auid" name="auid" 
	   								value="${auid}"> 
	  		 <input type="submit" value="Deliver Drugs">
		</form>
	</c:if>
	
</body>

<script type="text/javascript">

function updateRelValues(oCheckBox){
	var checkBocValue = oCheckBox.value;
	if (oCheckBox.checked == true){
		alert('add');
		IdValuesArray.push(checkBocValue);
	}else{
		for(var i = IdValuesArray.length - 1; i >= 0; i--) {
		    if(IdValuesArray[i] == checkBocValue) {
		    	IdValuesArray.splice(i, 1);
		    }
		}
	}
	$("#drugPresId").val(IdValuesArray);
}


</script>


</html>

