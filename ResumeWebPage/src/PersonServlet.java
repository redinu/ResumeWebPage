

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


@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt;
    Person p = new Person();
    String fName;
    String lName;
    String email;
    
    public PersonServlet() {
        super();
       
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		fName = request.getParameter("firstName");
		lName = request.getParameter("lastName");
		email = request.getParameter("email");
		ArrayList<Education> educations = (ArrayList<Education>) request.getSession().getAttribute("educations");
		Person person = savePerson();
		
		HttpSession session = request.getSession();
		session.setAttribute("person", person);
		session.setAttribute("educations", educations);
		
		getServletContext().getRequestDispatcher("/person.jsp").forward(request,response);
		
	}
	
	public Person savePerson(){
		
		String sql = "insert into person(firstName,lastName,email) values (?,?,?)";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fName);
			pstmt.setString(2, lName);
			pstmt.setString(3, email);

			pstmt.executeUpdate();
			
			p.setFirstName(fName);
			p.setLastName(lName);
			p.setEmail(email);

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p; 

	}

}
