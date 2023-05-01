

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc1_ser.Data;
import com.mvc1_ser.Service_logic;
public class update_ctrl4 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String email=request.getParameter("email");
		String ncont=request.getParameter("ncont");
		String ocont=request.getParameter("ocont");
		
		PrintWriter out=response.getWriter();
		
		Data d=new  Data();
	//	d.setEmail(email);
		d.setNcont(ncont);
		d.setOcont(ocont);
		
		Service_logic s=new Service_logic();
		
		int i=s.update_logic4(d);
		
		out.println("CONTACT NUMBER IS UPDATED"+ i);
		
		
		
	}

}
