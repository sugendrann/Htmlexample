
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/students";
		String user = "root";
		String password = "123456";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement("select * from persons");
			ResultSet rs = st.executeQuery();
			response.setContentType("text/html");
			writer.print("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />");
			writer.print("<h1>Display the results available in the persons database</h1>");
			writer.print(
					"<table border='1'><tr><th>PersonID</th><th>LastName</th><th>FirstName</th><th>Address</th><th>City</th>");
			
			while (rs.next()) {
				writer.print("<tr><td>");
				writer.print(rs.getInt(1));
				writer.print("</td>");
				writer.print("<td>");
				writer.print(rs.getString(2));
				writer.print("</td>");
				writer.print("<td>");
				writer.print(rs.getString(3));
				writer.print("</td>");
				writer.print("<td>");
				writer.print(rs.getString(4));
				writer.print("</td>");
				writer.print("<td>");
				writer.print(rs.getString(5));
				writer.print("</td></tr>");
			}
			writer.print("</table>");
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
