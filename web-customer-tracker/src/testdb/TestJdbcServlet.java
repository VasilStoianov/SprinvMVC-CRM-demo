package testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestJdbcServlet
 */
@WebServlet("/TestJdbcServlet")
public class TestJdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="lays";
		String pass="vasetow0w";
		String url="jdbc:mysql://10.252.242.94:3306/web_customer_tracker?useSSL-false";
		String driver = "com.mysql.jdbc.Driver";
		try {
			PrintWriter out = response.getWriter();
			out.print("Connecting to db");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			
			out.println("Connection Succes");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
