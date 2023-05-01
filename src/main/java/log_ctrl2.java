

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc1_ser.Data;
import com.mvc1_ser.Service_logic;
public class log_ctrl2 extends HttpServlet {

	
	  public void doGet(HttpServletRequest  req, HttpServletResponse resp) throws ServletException,IOException
	  {
		 PrintWriter  out=  resp.getWriter();
		   
		  
		  // reading ui data 
		  
		    String email= req.getParameter("email");
		    String pass= req.getParameter("pass");
		    
		    // to get data from DB, then goes to Service class/ logics class/dao class
		    
		      
		        
		     Service_logic  s=new Service_logic();
		     
		     Vector v=  s.log_logic2();
		       
		      // the above DB data(v)  compare to ui data
		     
		     HttpSession  hs=  req.getSession();
		     
		       if(v.contains(email) && v.contains(pass))
		       {
		    	    hs.setAttribute("email", email);
		    	    hs.setAttribute("pass", pass);
		    	    
		    	      RequestDispatcher  rd=req.getRequestDispatcher("view_ctrl3");
		    	        rd.forward(req, resp);
		    	     
		       }
		     
		        else
		        {
		        	 out.println("login FAIL"); 
		       RequestDispatcher  rd= 	req.getRequestDispatcher("ui2_login.html");
		        	   rd.include(req, resp);
		        }
		        
		        
	  }

}
