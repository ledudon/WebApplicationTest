import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usedb.DbInsertBean;
import usedb.DbSelectBean;

public class ChatCon23083 extends HttpServlet {
	private static String name = "山下悠太";
	private static String id = "AL23083";
	

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	//JSPのURL
    	String url = "";
    	String message = request.getParameter("message");
    	
    	// httpセッションを取得
    	HttpSession session = request.getSession(true);
    	
    	// messageが"Q"かどうかで分岐
		if(message.equals("Q")) {
			url = "/chatView23083.jsp";
			
			// DbSelectBeanでテーブルデータを作り、sessionに格納
			DbSelectBean selectb = new DbSelectBean();
			selectb.makeTableData(id);
			session.setAttribute("selectbid", selectb);
		}
		else {
			url = "/chatResult23083.jsp";
			
			// DbInserBeanにメッセージを格納しテーブルに挿入、sessionに格納
			DbInsertBean insertb = new DbInsertBean();
			insertb.setMessage(message);
			insertb.dbInsert(id, name);
			session.setAttribute("insertbid", insertb);
		}
		
		// フォワーディング
		RequestDispatcher dispatcher
	                   = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
    }
}