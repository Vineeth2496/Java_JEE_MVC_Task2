

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class end extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		// Closing page 
		
		hs.invalidate();
		
		PrintWriter out=response.getWriter();
		
		out.println("Sucessfully log out");
		
		RequestDispatcher rd=request.getRequestDispatcher("ui2_login.html");
		
		rd.include(request, response);
		
	
	
	}

}
