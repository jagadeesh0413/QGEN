import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addstudentbio")
public class Addstudentbio extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		p.print("Values Updated.");
		Connection con=DBUtil.createconnection();
	String name=request.getParameter("name");
	String rollno=request.getParameter("rollno");
	String email=request.getParameter("email");
	String phoneno=request.getParameter("phoneno");
	String department=request.getParameter("department");
	String query1="insert into addstudentbio values(?,?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(query1);
		ps.setString(1,name);
		ps.setString(2,rollno);
		ps.setString(3,email);
		ps.setString(4,phoneno);
		ps.setString(5,department);
	int row=ps.executeUpdate();
	if(row>=1) {
		RequestDispatcher r=request.getRequestDispatcher("Studentsuccess.html");
			r.forward(request, response);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	
	
	}
}