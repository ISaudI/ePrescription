<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	 var drugPosition = 0;
	  $("#getDetails").click(function(){
		  var arogyaId = $("#patientau360Id").val();
		  alert(arogyaId);
	    $.get("./selectPatient.html?arogyaId="+arogyaId+"&",function(data,status){
	      $("#patientDetailsDiv").html(data);
	    });
	  });
	  
	  
	  $("#addDrug").click(function(){
		$("#totalNumber").val(drugPosition);
		alert($("#totalNumber").val());
		var x = '<tr>'+
          '<td><input type="hidden" value="'+$("#drugId").val()+'" id="prescriptionDrugRel'+drugPosition+'.presDrugRelDrugId" name="prescriptionDrugRel['+drugPosition+'].presDrugRelDrugId"/>'+
          '<input value="'+$("#drugId option:selected").text()+'" id="prescriptionDrugRel'+drugPosition+'.presDrugRelDrugName" name="prescriptionDrugRel['+drugPosition+'].presDrugRelDrugName"/></td>'+
          '<td><input value="'+$("#drugDosage").val()+'" id="prescriptionDrugRel'+drugPosition+'.presDrugRelDosage"  name="prescriptionDrugRel['+drugPosition+'].presDrugRelDosage"/></td>'+
          '<td><input value="'+$("#drugFrequency").val()+'" id="prescriptionDrugRel'+drugPosition+'.presDrugRelFrequency"  name="prescriptionDrugRel['+drugPosition+'].presDrugRelFrequency"/></td>'+
       '</tr>';
       $("#drugDivison_medicines_body").append(x)
       drugPosition++;
		  
	  });
	  
	  
	});

</script>
<title>Doctor Page</title>
</head>
<body>
<fmt:setBundle basename="resources.eprescription-resources"/>
<p>
<c:forEach items="${drugList}" var="current" varStatus="i">

</c:forEach>

   <a class="button" 
	href="${pageContext.request.contextPath}/indexPrescriptionByDoctorId.html?doctorId=${doctor_details.doctorId}&">Presctiptions</a>
</p>
<div id="doctorDiv">
 <h3 style="padding-left: 45%">Dr.${doctor_details.doctorName }</h3>
 ${patient.emailId}
</div>
<div id="mainDiv">
  <div id="right" style="float: left; width: 30%">
     Patient Auid  <input type="text" id="patientau360Id" name="patientau360Id" />
       <input type="button" value="Get Details" id="getDetails">
       <div id="patientDetailsDiv">&nbsp;
           
       </div>
  </div>
  <div id="left">
    <div id="drugDisplay">
        <table>
           <tr>
               <td> Drug Name</td>
               <td> <select id="drugId" > 
		  			<option>--select--</option>
		 				<c:forEach items="${drugList}" var="current" varStatus="i">
		 					 <option value="${current.drugId}"> ${current.drugName} - ${current.drugType}</option>
						</c:forEach>
					</select>  
				</td>
           </tr>
           <tr>
               <td>Drug Dosage</td>
               <td><input type="text" id="drugDosage"></td>
          </tr>
          <tr>
               <td>Drug Frequency</td>
               <td><input type="text" id="drugFrequency"></td>
          </tr>
          <tr>
               <td>&nbsp;</td>
               <td><input type="button" id="addDrug" value="Add Drug"></td>
          </tr>
        </table>
 
		
    </div>
    
    <div id="drugDivison">
        <form action="${pageContext.request.contextPath}/savePrescription.html" method="POST" >
         <input type="hidden" id="totalNumber" name="totalNumber" />
           <div id="drugDivison_medicines">
               <table style="padding-left: 30%">
                  <thead>
                    <tr>
                       <th>Drug Name</th>
                       <th>Drug Dosage</th>
                       <th>Drug Frequency</th>
                    </tr>
                  </thead>
                  <tbody id="drugDivison_medicines_body">
                    
                  </tbody>
               </table>
           </div>
           <div>
               <input type="submit" value="Generate Prescription" style="float:right; margin-right: 300px">
           </div>
          
        </form>
        
    </div>
  </div>
</div>
</body>
</html>