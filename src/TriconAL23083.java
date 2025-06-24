import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TriconAL23083 extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	//JSPのURL
    	String url="/triangleAL23083.jsp";
		RequestDispatcher dispatcher
	                   =getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
    }
}