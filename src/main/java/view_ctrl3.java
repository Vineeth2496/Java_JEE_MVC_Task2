

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
public class view_ctrl3 extends HttpServlet {

	
	  public void doGet(HttpServletRequest  req, HttpServletResponse  resp) throws ServletException,IOException
	  {
     PrintWriter  out=  resp.getWriter();
   
      // out.println("WELCOME TO INBOX");
   
		  
		  // communicate with Logic class/service class
       
      
       // reading data from servler and forwarding to  Data class
       
       
     HttpSession  hs= req.getSession(false);
     
     if(hs != null)
     {
       
        String email=(String)hs.getAttribute("email");
          
       
           Data  d=new Data();
            d.setEmail(email);

            
            
            // calling logic class and keeing d object data
            
            
              Service_logic  s=new Service_logic();
              
             Vector  v= s.view_logic3(d);
        
               // from V fetching
             
              
            Iterator  ii=   v.iterator();
               
              for(;ii.hasNext();)
              {
            	  out.println(ii.next());  
              }
             
             out.println("<a href='end'>Logout</a>");
     }
     else 
     {
    	 out.println("Pls Login");
    	 RequestDispatcher rd=req.getRequestDispatcher("ui2_login.html");
    	 rd.include(req, resp);
     }
             
        
       
       
       
	  }
	  

}
