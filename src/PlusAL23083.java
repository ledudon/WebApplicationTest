import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PlusAL23083 extends HttpServlet {
	public void doGet(HttpServletRequest request,
            		  HttpServletResponse response)
	    throws IOException, ServletException
	{
		int x = Integer.parseInt(request.getParameter("numX")),
			y = Integer.parseInt(request.getParameter("numY"));
		String sum = Integer.toString ( x + y );
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Calculatation</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> 計算結果は、" + sum + "です。 </h1>");
		out.println("</body>");
		out.println("</html>");
}
}
