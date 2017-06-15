

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;
    Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt;   
    
    
    public SkillServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sk = request.getParameter("skill");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		HttpSession session = request.getSession();
		Skills skill = saveSkill(sk, rating);
		session.setAttribute("skill", skill);
		
		getServletContext().getRequestDispatcher("/resume.jsp").forward(request, response);
	}

	public Skills saveSkill(String sk, int rating){
		
		String querry = "insert into skills(skill,rating) values(?,?)"; 
		Skills skl = new Skills();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			PreparedStatement pstmt = con.prepareStatement(querry);
			pstmt.setString(1, sk);
			pstmt.setInt(2, rating);
			
			skl.setSkill(sk);
			skl.setRating(rating);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return skl;
			
	}
}
