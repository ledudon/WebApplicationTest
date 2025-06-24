import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import simple.SimpleBean;

public class SimpleServlet3 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	// Get引数から「名前」をとってくる
    	String name = request.getParameter("MYNAME");

    	// Beanを作る（「名前」から「メッセージ」を作る）
    	SimpleBean sb = new SimpleBean();
    	sb.setName(name);
    	sb.calc();

    	// セッションの属性として永続化されているBeanを登録する．
    	HttpSession session = request.getSession(true);
    	session.setAttribute("sbid", sb);

    	// このサーブレットの入出力を渡して，JSPを呼び出す．
    	// Beanに設定だれたデータをJSPの中で使う．
    	String url="/output2.jsp";
    	RequestDispatcher dispatcher
                   = getServletContext().getRequestDispatcher(url);
    	dispatcher.forward(request, response);
    }
}
