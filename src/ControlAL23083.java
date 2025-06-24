import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calculation.PlusBean;

public class ControlAL23083 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	// Get引数からnumX, numYをとってくる
    	String numX = request.getParameter("numX");
    	String numY = request.getParameter("numY");

    	// Beanを作る（numX, numYからexpressionとresultを作る）
    	PlusBean pb = new PlusBean();
    	pb.setExpression(numX, numY);
    	pb.calc();

    	// requestの属性として永続化されているBeanを登録する
    	request.setAttribute("pbid", pb);

    	// このサーブレットの入出力を渡して，JSPを呼び出す．
    	// Beanに設定されたデータをJSPの中で使う．
    	String url="/viewAL23083.jsp";
    	RequestDispatcher dispatcher
                   = getServletContext().getRequestDispatcher(url);
    	dispatcher.forward(request, response);
    }
}
