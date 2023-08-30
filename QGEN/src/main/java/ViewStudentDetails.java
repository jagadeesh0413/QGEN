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

@WebServlet("/ViewStudentDetails")
public class ViewStudentDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();
        Connection c = DBUtil.createconnection();
        String query = "SELECT * FROM addstudentbio";
        try {
            p.print("<!DOCTYPE html>\r\n"
                    + "<html lang=\"en\">\r\n"
                    + "<head>\r\n"
                    + "<title>Student Information</title>\r\n"
                    + "<meta charset=\"UTF-8\">\r\n"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css1/util.css\">\r\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css1/main.css\">\r\n"
                    + "<style>\r\n"
                    + "    body {\r\n"
                    + "        background-color: #222;\r\n"
                    + "        color: #fff;\r\n"
                    + "    }\r\n"
                    + "    table {\r\n"
                    + "        width: 100%;\r\n"
                    + "        border-collapse: collapse;\r\n"
                    + "    }\r\n"
                    + "    th, td {\r\n"
                    + "        padding: 12px 15px;\r\n"
                    + "        text-align: left;\r\n"
                    + "        border-bottom: 1px solid #ddd;\r\n"
                    + "    }\r\n"
                    + "    th {\r\n"
                    + "        background-color: #333;\r\n"
                    + "        color: #fff;\r\n"
                    + "    }\r\n"
                    + "</style>\r\n"
                    + "</head>\r\n"
                    + "<body>\r\n"
                    + "<div class=\"limiter\">\r\n"
                    + "<div class=\"container-table100\">\r\n"
                    + "<div class=\"wrap-table100\">\r\n"
                    + "<div class=\"table100 ver1 m-b-110\">\r\n"
                    + "<div class=\"table100-head\">\r\n"
                    + "<table>\r\n"
                    + "<thead>\r\n"
                    + "<tr class=\"row100 head\">\r\n"
                    + "<th class=\"cell100 column1\">Student Name</th>\r\n"
                    + "<th class=\"cell100 column2\">Roll No</th>\r\n"
                    + "<th class=\"cell100 column3\">Email</th>\r\n"
                    + "<th class=\"cell100 column4\">Phone No</th>\r\n"
                    + "<th class=\"cell100 column5\">Department</th>\r\n"
                    + "</tr>\r\n"
                    + "</thead>\r\n"
                    + "</table>\r\n"
                    + "</div>\r\n"
                    + "<div class=\"table100-body js-pscroll\">\r\n"
                    + "<table>\r\n"
                    + "<tbody>\r\n");
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.println("<tr class=\"row100 body\"><td class=\"cell100 column1\">" + rs.getString(1) + "</td>\r\n"
                        + "<td class=\"cell100 column2\">" + rs.getString(2) + "</td>\r\n"
                        + "<td class=\"cell100 column3\">" + rs.getString(3) + "</td>\r\n"
                        + "<td class=\"cell100 column4\">" + rs.getString(4) + "</td>\r\n"
                        + "<td class=\"cell100 column5\">" + rs.getString(5) + "</td>\r\n"
                        + "</tr>");
            }

            p.println("</tbody>\r\n"
                    + "</table>\r\n"
                    + "</div>\r\n"
                    + "</div>\r\n"
                    + "</div>\r\n"
                    + "</div>\r\n"
                    + "</div>\r\n"
                    + "<script>\r\n"
                    + "    $('.js-pscroll').each(function () {\r\n"
                    + "        var ps = new PerfectScrollbar(this);\r\n"
                    + "        $(window).on('resize', function () {\r\n"
                    + "            ps.update();\r\n"
                    + "        })\r\n"
                    + "    });\r\n"
                    + "</script>\r\n"
                    + "</body>\r\n"
                    + "</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
