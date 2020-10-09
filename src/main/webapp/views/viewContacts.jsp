<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<script>
function confirmDltnRcrd(){
      return confirm("are you sure , you want to delete");
}
</script>

<body class="container"
	style="height: 100px; background-color: rgba(254, 112, 86)">
	<br>
	<h3>${dltdMsg}</h3><br>
	<h3>
		<a href="/">+Add New Contact </a>
	</h3>
	<form:form modelAttribute="cntcts">
		<table border="1">
			<tr>
				<th>Name</th>
				<th>MailId</th>
				<th>Number</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${cntcts}" var="cntct">
				<tr>
					<td>${cntct.cname}</td>
					<td>${cntct.cmail}</td>
					<td>${cntct.cnum}</td>
					<td><a href="editCntct?cid=${cntct.cid}">Edit</a> 
				    <a href="deleteCntct?cid=${cntct.cid}" onclick="return confirmDltnRcrd()">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>