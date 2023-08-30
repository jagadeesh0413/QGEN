import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ Addfaculty ")
public class Addfaculty extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection con=DBUtil.createconnection();
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String query="insert into addfaculty values(?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,username);
		ps.setString(2,password);
		int rowcount=ps.executeUpdate();
		if(rowcount>=1) {
			RequestDispatcher r=request.getRequestDispatcher("success.html");
			r.forward(request, response);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	
	
	}
}