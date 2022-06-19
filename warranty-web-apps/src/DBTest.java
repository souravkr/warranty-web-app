

import java.io.IOException;
import java.io.PrintWriter;


import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDb")
public class DBTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pass="springstuden";
		String user="springstuden";
		
		String url ="jdbc:mysql://localhost:3306/warranty_app?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			
			out.println("connecting to db");
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url,pass,user);
			
			out.println("Success");
			
            connection.close();	
		}
		catch( Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
			
		}
				
	}

}

