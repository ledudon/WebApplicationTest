<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="selectbid" class="usedb.DbSelectBean" scope="session"/>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>チャット一覧</title>
</head>

<body>
	<center>
	
	<h1> 最新チャットメッセージ20件	</h1>
	
	<table border="1" width="900">
		<tr>
			<th>発信者</th>
			<th>友達メッセージ</th>
			<th>更新日/時刻</th>
			<th>私のメッセージ</th>
		</tr>
		<%
			List<String[]> chatList = selectbid.getChatList();
			for(String[] row : chatList){
		%>
			<tr>
			<% for(String cell : row){ %>
				<td><%= cell %></td>
			<% } %>
			</tr>
		<% 
			}
		%>
	</table>
	
	</center>
</body>

</html>
