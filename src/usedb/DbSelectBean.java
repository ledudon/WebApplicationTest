package usedb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbSelectBean implements Serializable {
	private List<String[]> chatList;
	private Connection con;
	private static int maxCols = 20;
	
	public DbSelectBean(){
		try {
			// ドライバクラスをロード
			Class.forName("org.postgresql.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String[]> getChatList(){
		if (chatList == null) {
	        return new ArrayList<>();
	    }
		return chatList;
	}
	
	public void makeTableData(String id) {
		chatList = new ArrayList<String[]>();
		try {
			// データベース接続
			// local
			// con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/test1", "shibaura", "toyosu"); 
			// 大学サーバー
			con = DriverManager.getConnection("jdbc:postgresql://172.21.87.228:5433/test1", "shibaura", "toyosu");
			
			// 新しい順でテーブルを取得
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM T_LOG ORDER BY WRITTENDATE DESC";
			ResultSet rs = stmt.executeQuery(sql);
			
			// 20行分chatListに追加
			for(int i = 0; i < maxCols && rs.next(); i++) {
				String[] chat = new String[4];
				String name = rs.getString("NAME");
				String message = rs.getString("MESSAGE");
				Timestamp chatTime = rs.getTimestamp("WRITTENDATE");
				
				// idによってメッセージと名前を入れる場所を分岐
				if(id.equals(rs.getString("ID"))) {
					chat[0] = "";
					chat[1] = "";
					chat[3] = message;
				}
				else {
					chat[0] = name;
					chat[1] = message;
					chat[3] = "";
				}
				
				// 日付で比較してMM/ddかHH:mmか分岐
				String timestamp = "";
				LocalDate today  = LocalDate.now();
				LocalDateTime chatDateTime = chatTime.toLocalDateTime();
				
				// 日付によって処理分岐
				if(today.equals(chatDateTime.toLocalDate())) { // 日付が今日の場合
					timestamp = chatDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
				}
				else if(today.isBefore(chatDateTime.toLocalDate())) { // 日付が今日より前の場合
					timestamp = chatDateTime.format(DateTimeFormatter.ofPattern("MM/dd"));
				}
				else { // 日付が今日より後の場合(未来の場合)
					// おそらく9時間プラスしていないチャットだと考えられるため
					// 9時間戻して表示する
					timestamp = chatDateTime.minusHours(9).format(DateTimeFormatter.ofPattern("MM/dd"));
				}
				chat[2] = timestamp;
				
				// chat1行分をchatListに追加
				chatList.add(chat);
			}
			
			Collections.reverse(chatList);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
