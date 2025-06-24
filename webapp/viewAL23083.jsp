<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="pbid" class="calculation.PlusBean" scope="request"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Calculation</title>
</head>
<body>
	<h1><jsp:getProperty name="pbid" property="expression"/>の計算結果は
	<jsp:getProperty name="pbid" property="result"/>です</h1>
</body>
</html>
