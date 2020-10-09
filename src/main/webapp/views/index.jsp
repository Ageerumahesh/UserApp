<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
<!-- <script type="text/javascript" src="validation.js"></script> -->

<style>
div {
	width: 260px;
	background-color: #ffcccc;
	height: 25px;
	font-weight: bold;
	margin-left: 250px;
	text-align: left;
}

section {
	width: 285px;
	background-color: #ffebe6;
	height: 25px;
	margin-left: 280px;
	margin-top: -25px;
}

footer {
	width: 20px;
	background-color: #ffcccc;
	height: 25px;
	margin-left: 265px;
	margin-top: -20px;
}
</style>
</head>
<body class="container"
	style="height: 100px; background-color: rgba(254, 112, 86)">
	<form:form action="saveContact" modelAttribute="contact" method="POST">
		<div style="margin-top: 100px; width: 565px">
			<h3>Contact Form</h3>
		</div>
		<div style="margin-top: 3px">
			Contact Name <span style="color: #ff3300">*</span>
			<footer></footer>
			<section>
				<form:input path="cname" />
				<form:hidden path="cid"/>
			</section>
		</div>
		<div style="margin-top: 3px">
			Contact Mail <span style="color: #ff3300">*</span>
			<footer></footer>
			<section>
				<form:input path="cmail" />
			</section>
		</div>
		<div style="margin-top: 3px">
			Contact Number <span style="color: #ff3300">*</span>
			<footer></footer>
			<section>
				<form:input path="cnum" />
			</section>
		</div>
		<div style="margin-top: 3px">
		<input type="date" name="date" required>
        </div>
        
		<div style="margin-top: 3px">
		<input type="file" name="file" required>
        </div>
		<div style="margin-top: 3px; height: 26px; width: 50px">
			<input type="submit" value="Register" />
		</div>
		<div style="margin-top: 3px">
			Status <span style="color: #ff3300"></span>
			<footer></footer>
			<section>${sucssMsg}</section>
			<section>${errMsg}</section>
			<section>${updtMsg}</section>
		</div>
		<div style="margin-top: 3px; height: 26px;">
			<h3><a href="viewContacts">ViewAllContacts</a></h3>
		</div>
	</form:form>
</body>
</html>
