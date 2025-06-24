<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
	<title>Triangle</title>
</head>
<body>
	<%
	  int cols = Integer.parseInt(request.getParameter("cols"));
	  StringBuilder triangle = new StringBuilder("*");
	%>
	<% for(int i = 0; i < cols; i++){ %>
		<p><%= triangle.toString() %></p>
		<% triangle.append("*"); %>
	<%} %>
</body>
</html>
