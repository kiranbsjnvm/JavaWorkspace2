<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/myapp.css" var="myappCss" />
<spring:url value="/resources/js/angular.min.js" var="angularJs" />
<spring:url value="/resources/js/myapp.js" var="myappJs" />


<link href="${myappCss}" rel="stylesheet" />
<script src="${angularJs}"></script>
<script src="${myappJs}"></script>


</head>
<body ng-app="myApp" ng-controller="homeController">
	<h1>Home</h1>
	<h2>Enter your message</h2>

	<!-- <p><a href="webapi/messages">Get messages</a> -->

	
	
	<div id="createMsg">
		<form name="myForm" ng-submit="formSubmit()">
			<p>
				Message : <input type="text" name="Student" ng-model="message"
					ng-minlength="2" ng-required="true">
			</p>
			<p>
				Message : <input type="text" name="author" ng-model="author"
					ng-minlength="2" ng-required="true">
			</p>
			<p>
				<input type="date" name="createdDate" ng-model="created">
			</p>

			<button name="submit">Create Message</button>
		</form>
	</div>
	
	<hr>
	<button ng-click="getAllMessages()">Get All Messages</button>
	<div ng-repeat="msg in allMessages">
		<div id="displayBox">
			<p>Message : {{msg.message}} </p>
			<p>Author : {{msg.author}} </p>
			<p>Created at : {{msg.created}} </p>
		</div>
	</div>
</body>
</html>