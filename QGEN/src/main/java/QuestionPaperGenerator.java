import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/QuestionPaperGenerator")
public class QuestionPaperGenerator extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		String rownum=request.getParameter("rownum");
		String rownum1=request.getParameter("rownum1");
		Connection c=DBUtil.createconnection();
		String examname=request.getParameter("examname");
		String time=request.getParameter("time");
		String date=request.getParameter("date");
		String course=request.getParameter("course");
	    String query=" select * from(select * from qpgen order by dbms_random.random) where rownum<=?";
		String query1="select * from(select * from qpartb order by dbms_random.random) where rownum <=?";
	   try {
			PreparedStatement ps=c.prepareStatement(query);
			PreparedStatement ps1=c.prepareStatement(query1);
			ps.setString(1,rownum);
			ps1.setString(1, rownum1);
			ResultSet rs=ps.executeQuery();
			ResultSet rs1=ps1.executeQuery();
			p.print("<html><head><title>question paper generator</title><style> div{border-style:solid;border-color:black;}h5{text-align:center;}"
					+ "h1{text-align:center;} h3{text-align:center;} h5{text-align:right;}h4{text-align:center;}p{display:inline;}</style></head><body><div>"
					+ "<h1>KARPAGAM COLLEGE OF ENGINEERING</h1><center>(Autonomous)</center><center>Coimbatore-32</center>"
					+ "<center>"+ examname +"</center><center>"+course+"</center><h5><lable>Duration:</lable>"+time+"<br><lable>Date:</lable>"+date+"</h5><hr><h3>PART-A</h3>");
			
			int i=1,count=0;
			while(rs.next()) {	
				p.println(" "+i++ +" "+ "."+rs.getString(1)+" <p>"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</p><br>");
				  count++;
			}
			p.print("<h3>PART-B</h3>");
			//int j=count+1;
			while(rs1.next()) {
				p.println(" "+i++ +" "+"."+rs1.getString(1)+" <p>"+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" </p><br>"+rs1.getString(5)+" <p>"+rs1.getString(6)+" "+rs1.getString(7)+" "+rs1.getString(8)+"</p><br>");
			if(count%2!=0) {
				if(i%2!=0) {
					p.print("<center>or</center>");
					  }
			  else if(i%2==0) {
				  	p.print("<br><br>");
					  }
			}else {
				if(i%2==0) {
					p.print("<center>or</center>");
					  }
			  else if(i%2!=0) {
				  	p.print("<br><br>");
					  }
			}
			}
			p.println("</div></body></html>");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
