 package com.mvc1_ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Service_logic {
  
	
	 
	
	   public  static  Connection  myconn()
	    {
	   Connection  con=null;  	 
	    	
	         try
	    	 {
	    	
	    	/* FileInputStream   f=new FileInputStream("C:\\Users\\vnc it\\eclipse-workspace\\com.mvc1_ser\\src\\main\\java\\com\\mvc1_ser\\jdbc.properties");
	    	 
	    	   Properties  p=new Properties();
	    	   
	    	    p.load(f);
	    	    
	    		*/
	        	 
	    	  
	    	 
	       Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	       
	       con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	    	System.out.println(con);
	    	
	    	 }
	    	 catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
	    	 }
	        
	         
	         return  con;
	         
	    }// closing methods
	
	
	
	    
	   public  int  save_logic1(Data  d)
	   {
		    // to get conntection
		   
		   Connection  con=  Service_logic.myconn();
		     int res=1;
		     System.out.println(con);
		      try
		      {
		    // data sending to Databses using pst
		   
	 PreparedStatement  pst=   con.prepareStatement("insert into link343  values(?,?,?,?,?,?,?,?,?)");
		     
		    // for pst adding data 
		  
		   pst.setString(1, d.getEmail());
		   pst.setString(2, d.getPass());
		   pst.setString(3, d.getName());
		   pst.setString(4, d.getCont());
		   pst.setString(5, d.getGender());
		   pst.setString(6, d.getLang());
		   pst.setString(7, d.getInst());
		         
		         FileReader  fr=new FileReader(d.getFle());
		   pst.setCharacterStream(8, fr);
		       
		           String img=  d.getImg();
		             
		            System.out.println(img);
		            
		             FileInputStream  fi=new FileInputStream(img);
		           
		       pst.setBinaryStream(9, fi);
		   
		   
		    // updation
		   
		 int i=   pst.executeUpdate();
		     
		 
		      }// closing try
		      
		      catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			 return res;
			 }
		
		      return res;
	   }// closing methods
	   
	   
	   
	   
	   public Vector log_logic2()
	   {
		   // connection

	          Vector  v=new Vector();
	         

		    try
		    {
	       Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	       
	      RowSetFactory  rf=  RowSetProvider.newFactory();
	        
	      JdbcRowSet  jr=   rf.createJdbcRowSet();
	         
	         jr.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	         jr.setUsername("system");
	         jr.setPassword("manager");
	         jr.setCommand("select email,pass from link343");
	         jr.execute();
	         
	         // from jr feching
	          
	          for(;jr.next();)
	          {
	        	v.add(jr.getString("email"));
	        	v.add(jr.getString("pass"));
	        	  
	          }
	         
		    }
		    catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
		    }
	       
		    
		    return  v;
		    
	   }
	   
	   
	   
	   public Vector view_logic3(Data  d)
	   {
		   

		   // connection

	          Vector  v=new Vector();
	         

		    try
		    {
	       Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	       
	      RowSetFactory  rf=  RowSetProvider.newFactory();
	        
	      JdbcRowSet  jr=   rf.createJdbcRowSet();
	         
	         jr.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	         jr.setUsername("system");
	         jr.setPassword("manager");
	         jr.setCommand("select * from link343  where email=?");
	          
	          jr.setString(1, d.getEmail());
	         
	         jr.execute();
	         
	         // from jr feching
	          
	          for(;jr.next();)
	          {
	        	v.add(jr.getString("email"));
	        	v.add(jr.getString("pass"));
	        	v.add(jr.getString("name"));
	        	v.add(jr.getString("cont"));
	        	v.add(jr.getString("gender"));
	        	v.add(jr.getString("lang"));
	        	v.add(jr.getString("inst"));
	        	
	       Reader  r= 	jr.getCharacterStream("fle");
	        	
	         for( int in; (in=r.read())!=-1;in++)
               {
	        	   System.out.print((char)in);
               }	       
	        	
	         
	         
	      InputStream  ii=jr.getBinaryStream("img");
	        	
	  	 File ff=new File("db.jpg");
	  	  FileOutputStream  fo=new FileOutputStream(ff);
	  	  
	  	  
	  	  
	         for( int in; (in=ii.read())!=-1;in++)
            {
	        	   fo.write(in);
	        	  
            }	       
	      
	          System.out.print(ff.getAbsolutePath());
	        	  
	          }
	         
		    }
		    catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
		    }
	       
		    
		    return  v;
		   
		   
	   }
	   
	   public int update_logic4(Data d)
	   {
		  Connection  con=  Service_logic.myconn();
	     int res=1;
	     System.out.println(con);
	     try
	     {
	    	 
	    	 PreparedStatement pst=con.prepareStatement("update link343 set cont=? where cont=?");
	    	 pst.setString(1, d.getNcont());
	    	 pst.setString(2, d.getOcont());
	    	 
	    	 int i=pst.executeUpdate();
	    	 
	     }
	     catch (Exception e) {
			// TODO: handle exception
	    	 e.printStackTrace();
			   return res;
		}
		   return res;
		   
	   }
	
}
