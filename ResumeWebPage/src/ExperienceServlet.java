

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


@WebServlet("/ExperienceServlet")
public class ExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt;
	
	ArrayList<Experience> experiences = new ArrayList<Experience>();
    
    public ExperienceServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ArrayList<Experience> expList = new ArrayList<Experience>();
	
		if(session != null && session.getAttribute("experiences") != null){
			expList = (ArrayList<Experience>) session.getAttribute("experiences");
			int size = Integer.parseInt(request.getParameter("counter"));
			for(int j=0;j<size;j++){
				int id = Integer.parseInt(request.getParameter("expId"));
				System.out.println(id);
				Experience exp = getExperienceById(id);
				expList.add(j,exp);
			}
			
		}
		
		String sDate = request.getParameter("startDate");
		String eDate = request.getParameter("endDate");
		String pos = request.getParameter("position");
		String comp = request.getParameter("company");
		String duty = request.getParameter("duty");
		
		expList.add(saveExperience(sDate, eDate, pos, comp, duty));
		
		session.setAttribute("experiences", expList);
		
		
		getServletContext().getRequestDispatcher("/experience.jsp").forward(request, response);
	}
	
	public Experience saveExperience(String sDate, String eDate, String pos, String comp, String dut){
		
		Experience exp = new Experience();
		System.out.println("");
		String querry = "insert into experience(startDate,endDate,company,position) values(?,?,?,?)";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			PreparedStatement pstmt = con.prepareStatement(querry);
			pstmt.setString(1, sDate);
			pstmt.setString(2, eDate);
			pstmt.setString(3, comp);
			pstmt.setString(4, pos);
			pstmt.executeUpdate();
			
			String getId = "select experienceId FROM experience ORDER BY experienceId DESC LIMIT 1 ;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getId);
			int expId = 0;
			if(rs.next()){
				expId = rs.getInt("experienceId");
			}
			
			exp.setExperienceId(expId);
			exp.setCompany(comp);
			exp.setPosition(pos);
			exp.setEndDate(eDate);
			exp.setStartDate(sDate);
			
			Duty duty = saveDuty(dut,expId,exp);
			ArrayList<Duty> dutyList = new ArrayList<Duty>();
			dutyList.add(duty);
		    exp.setDuty(dutyList);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return exp;
	}
	
	public Duty saveDuty(String dut,int experienceId, Experience exp){
		
		String querry = "insert into duty(duty, experienceId) values(?, ?)";
		Duty duty = new Duty();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			PreparedStatement pstmt = con.prepareStatement(querry);
			pstmt.setString(1, dut);
			pstmt.setInt(2, experienceId);
			pstmt.executeUpdate();

			duty.setDuty(dut);
			duty.setEx(exp);
			

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return duty;
		
	}
	
public Experience getExperienceById(int id){
		
		Experience ex = new Experience() ;
		String querry = "Select * from experience where experienceId = " + id + ";";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querry);
			
			
			while(rs.next()){
				ex.setStartDate(rs.getString("startDate"));
				ex.setEndDate(rs.getString("endDate"));
				ex.setCompany(rs.getString("company"));
				ex.setPosition(rs.getString("position"));
				
			}
			
			Duty duty = getDutyByExId(id);
			ArrayList<Duty> dutList = new ArrayList<Duty>();
			dutList.add(duty);
			
			ex.setDuty(dutList);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ex; 
	}
	

	public Duty getDutyByExId(int id){
	
		Duty d = new Duty();
	
		String querry = "Select * from duty where experienceId = " + id + ";";
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
				+ "user=root&password=password");

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querry);
		
		
			while(rs.next()){
				d.setDuty(rs.getString("duty"));
			
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return d; 
}

}


