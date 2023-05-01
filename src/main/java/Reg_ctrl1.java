

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc1_ser.Data;
import com.mvc1_ser.Service_logic;
public class Reg_ctrl1 extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	  {
		   // reading ui data
		  
		  
		   String email= req.getParameter("email");

		   String pass= req.getParameter("pass");

		   String name= req.getParameter("name");

		   String cont= req.getParameter("cont");

		   String gender= req.getParameter("gender");

		   String lang= req.getParameter("lang");

		   String inst= req.getParameter("inst");

		   String fle= req.getParameter("fle");

		   String img= req.getParameter("img");

		   
		  PrintWriter  out=  resp.getWriter();
		     
		 //  the above  ui data/values  forword  to "Data" class of setter methods, bcse setter methods holding data
		  
		  Data  d=new Data();
    
		  d.setEmail(email);
      d.setPass(pass);
      d.setName(name);
      d.setCont(cont);
      
      d.setGender(gender);
      
      d.setLang(lang);
d.setInst(inst);
d.setFle(fle);
d.setImg(img);

      // calling Service_logic class of methods

   Service_logic  s=new Service_logic();
   
   
   Connection  con=  Service_logic.myconn();
   
      out.println(con);
      
   
     int i= s.save_logic1(d);
		   
       
        out.println(" updated :"+i);
        
		    
	  }

}
