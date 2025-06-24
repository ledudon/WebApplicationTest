import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlusconAL23083 extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	String url = "";
    	try 
    	{
    		Integer.parseInt(request.getParameter("numX"));
    		Integer.parseInt(request.getParameter("numY"));
    		
        	//JSPのURL
        	url = "/plusAL23083.jsp";
    	}
    	catch(NumberFormatException e) 
    	{
    		url = "/error.html";
    	}
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    	dispatcher.forward(request, response);
    }
}