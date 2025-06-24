<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
	<title>Calculation</title>
</head>

<body>
	<%
	  int x = Integer.parseInt(request.getParameter("numX"));
	  int y = Integer.parseInt(request.getParameter("numY"));
	  String sum = Integer.toString(x + y);
	%>
	<h1>計算結果は、<%= sum %>です。</h1>
</body>
</html>
