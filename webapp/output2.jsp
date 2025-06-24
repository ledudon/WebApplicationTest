<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="sbid" class="simple.SimpleBean" scope="session"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hello world</title>
</head>
<body>
	<h1> こんにちは </h1>
	<h2>ようこそ！<jsp:getProperty name="sbid" property="name"/>
	さん、こんにちは！</h2>
	余計なお世話ですが、<jsp:getProperty name="sbid" property="message"/>
</body>
</html>
