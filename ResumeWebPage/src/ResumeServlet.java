

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ResumeServlet() {
        super();
        
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person person = (Person) request.getSession().getAttribute("person");
		Education edu = (Education) request.getSession().getAttribute("education");
		Experience exp = (Experience)request.getSession().getAttribute("experience");
	
		
		request.getSession().setAttribute("person", person);
		request.getSession().setAttribute("education", edu);
		request.getSession().setAttribute("experience", exp);
		
		getServletContext().getRequestDispatcher("/resume.jsp").forward(request,response);
	}

}
