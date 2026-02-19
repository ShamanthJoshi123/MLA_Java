<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exceptions</title>
</head>
<body>
		<% //pure java tag
			int x=100;
			int y=0;
			out.println(x/y);
		%>
</body>
</html>