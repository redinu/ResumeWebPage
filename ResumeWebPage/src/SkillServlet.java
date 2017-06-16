

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    ArrayList<Skills> SkillList = new ArrayList<Skills>();
    Skills skl = new Skills();
    public SkillServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SkillList = new ArrayList<Skills>();
		HttpSession session = request.getSession(false);
		ArrayList<Skills> skList = new ArrayList<Skills>();
	
		if(session != null && session.getAttribute("skills") != null){
			skList = (ArrayList<Skills>) session.getAttribute("skills");
			
		}
		
		String sk = request.getParameter("skill");
		String rating = request.getParameter("rating");
		
		
		Skills skill = saveSkill(sk, rating);
		skList.add(skill);
		session.setAttribute("skills", skList);
		
		getServletContext().getRequestDispatcher("/resume.jsp").forward(request, response);
	}

	public Skills saveSkill(String sk, String rating){
		
		String querry = "insert into skills(skill,rating) values(?,?)"; 
		 skl = new Skills();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			PreparedStatement pstmt = con.prepareStatement(querry);
			pstmt.setString(1, sk);
			pstmt.setString(2, rating);
			
			skl.setSkill(sk);
			skl.setRating(rating);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return skl;
			
	}
	
public Skills getSkillById(int id){
		
		Skills sk = new Skills() ;
		String querry = "Select * from skills where skillId = " + id + ";";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querry);
			
			
			while(rs.next()){
				sk.setRating(rs.getString("rating"));
				sk.setSkill(rs.getString("skill"));
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sk; 
	}
	
}
