

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt;
    Education edu = new Education();
    ArrayList<Education> ed = new ArrayList<Education>();
    public EducationServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ed = new ArrayList<Education>();
		HttpSession session = request.getSession(false);
		int size = 0;
		if(session != null && session.getAttribute("educations") != null){
			ed = (ArrayList<Education>) session.getAttribute("educations");
		
		}
		
		String degree = request.getParameter("typeOfDegree");
		String inst = request.getParameter("institute");
		String eDate = request.getParameter("endDate");
		
		ed.add(saveEducation(degree, inst, eDate));
		session.setAttribute("educations", ed);
		
		getServletContext().getRequestDispatcher("/education.jsp").forward(request,response);
		
	}
	
	public Education saveEducation(String degree, String inst, String eDate){
		edu = new Education();
		String query = "insert into education(degree, institute,endDate) values(?,?,?)";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, degree);
			pstmt.setString(2, inst);
			pstmt.setString(3, eDate);
			pstmt.executeUpdate();
			edu.setTypeOfDegree(degree);
			edu.setInstitute(inst);
			edu.setEndDate(eDate);
			
			String getId = "select educationId FROM education ORDER BY educationId DESC LIMIT 1 ;";
			System.out.println(getId);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getId);
			int eduId = 0;
			if(rs.next()){
				eduId = rs.getInt("educationId");
			}
			
			edu.setEducationId(eduId);

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return edu; 
	}
	
public Education getEducationById(int id){
		
		String querry = "Select * from education where educationId = " + id + ";";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querry);
			
			while(rs.next()){
				edu.setTypeOfDegree(rs.getString("degree"));
				edu.setInstitute(rs.getString("degree"));
				edu.setEndDate(rs.getString("degree"));
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return edu; 
	}

}
