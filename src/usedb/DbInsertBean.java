package usedb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class DbInsertBean implements Serializable {
	private String message = "";
	private Connection con;
	private PreparedStatement prestmt;
	
	public DbInsertBean(){
		try {
			// ドライバクラスをロード
			Class.forName("org.postgresql.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMessage(String m) {
		this.message = m;
	}
	
	public String getMessage() {
		return this.message;
	}
	
    public void dbInsert(String id, String name) {
    	try {
    		// データベース接続
			// local
			// con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/test1", "shibaura", "toyosu"); 
			// 大学サーバー
			con = DriverManager.getConnection("jdbc:postgresql://172.21.87.228:5433/test1", "shibaura", "toyosu");
			
			String sql = "INSERT INTO T_LOG VALUES (?,?,?,?)";
			prestmt = con.prepareStatement(sql);
			
			// 値の挿入、テーブル更新
			prestmt.setString(1, id);
			prestmt.setString(2, name);
			prestmt.setString(3, message);
			prestmt.setTimestamp(4, new Timestamp(System.currentTimeMillis() + 32400000));
			prestmt.executeUpdate();
    	}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}
