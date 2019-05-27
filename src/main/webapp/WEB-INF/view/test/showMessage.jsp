<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf8">
		<title>SSM Demo Index</title>
		
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/jQuery/jquery.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/common.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/test/showMessage.css" />
			
	</head>
<body>
	<div class="container">
		<h2>Welcome to ssm demo! - showMessage</h2>
	</div>
	
	<div class="container">
		<p>The message is : ${message}</p>
	</div>
</body>
</html>