<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="insertbid" class="usedb.DbInsertBean" scope="session"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>chat result</title>
</head>
<body>
	<h1> 
		メッセージ
		「<jsp:getProperty name="insertbid" property="message"/>」
		を登録しました
	</h1>
</body>
</html>
