
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Resume {

	Person person = new Person();
	ArrayList<Education> education= new ArrayList<Education>();
	ArrayList<Experience> experience = new ArrayList<Experience>();
	ArrayList<Skills> skills = new ArrayList<Skills>();
	boolean hasNext = true;
	boolean isValid = false;
	String addMore = "y";
	

	Scanner scn = new Scanner(System.in);
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt;


	public void saveResume() {

		savePerson();
		saveEducation();
		saveExperience();
		saveSkill();
	}

	public void printResume()	{

		System.out.println("================================================");
		System.out.print(person.getFirstName() + " ");


		System.out.print(person.getLastName());
		System.out.println();

		System.out.println(person.getEmail());
		System.out.println();

		System.out.println("Education");
		for(Education ed: education){

			System.out.println(ed.getTypeOfDegree() + ",");
			System.out.print(ed.getInstitute() + ", ");
			System.out.println(ed.getEndDate());
			System.out.println();
		}
		System.out.println();

		System.out.println("Experience");
		for(Experience ex: experience){

			System.out.println(ex.getPosition());
			System.out.print(ex.getCompany() + ", ");
			System.out.println(ex.getStartDate() + "-" + ex.getEndDate());
			for(String s: ex.getDuty()){
				System.out.println("Duty 1:" + s);
			}

			System.out.println();
		}
		System.out.println();

		System.out.println("Skills");
		for(Skills sk: skills){
			System.out.println(sk.getRating());

		}

	}



	public void savePerson(){
		String fName = "";
		String lName = "";
		while(!isValid){
		System.out.println("Please enter your first name");
		 fName = scn.nextLine();
		person.setFirstName(fName);
		if (!fName.matches("[a-zA-Z_]+")) {
		    System.out.println("Invalid name");
		}else {
			isValid = true;
		}
		}
		isValid = false;
		while(!isValid){
		System.out.print("Please enter your last name");
		 lName = scn.nextLine();
		person.setLastName(lName);
		if (!lName.matches("[a-zA-Z_]+")) {
		    System.out.println("Invalid name");
		}else{
			isValid = true;
		}
		}
		System.out.println();

		System.out.println("Enter your email address");
		String email = scn.nextLine();
		person.setEmail(email);

		System.out.println();
		
		
		String FullName = "insert into person(firstName,lastName,email) values (?,?,?)";


		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
					+ "user=root&password=password");

			pstmt = con.prepareStatement(FullName);
			pstmt.setString(1, fName);
			pstmt.setString(2, lName);
			pstmt.setString(3, email);

			pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 


	}


	public void saveEducation(){
		System.out.println("Enter your education");
		System.out.println("Enter the type of degree you get?");
		String degree = "";
		String eDate = "";
		String inst  = "";

		while (hasNext){
			isValid = false;
			Education edu1 = new Education();
			while(!isValid){
			degree = scn.nextLine();
			edu1.setTypeOfDegree(degree);
			if (!degree.matches("[a-zA-Z_]+")) {
			    System.out.println("Invalid name");
			}else{
				isValid = true;
			}
			}
			isValid = false;
			
			while(!isValid){
			System.out.println("Enter the institute?");
			inst = scn.nextLine();
			edu1.setInstitute(inst);
			if (!inst.matches("[a-zA-Z_]+")) {
			    System.out.println("Invalid name");
			}else{
				isValid = true;
			}
			}
			isValid = false;


			while(!isValid){
			System.out.println("Enter the end date?");
			eDate = scn.nextLine();
			edu1.setEndDate(eDate);
			if (!eDate.matches("[0-9]+")) {
			    System.out.println("Invalid number");
			}else{
				isValid = true;
			}
			}
			isValid = false;

			System.out.println("Do you want to add another education?");

			education.add(edu1);

			if(addMore.equalsIgnoreCase(scn.nextLine())){
				hasNext = true;

			}else{
				hasNext = false;

			}

			System.out.println("");

			String edu = "insert into education(degree, institute,endDate) values(?,?,?)";

			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
						+ "user=root&password=password");

				pstmt = con.prepareStatement(edu);
				pstmt.setString(1, degree);
				pstmt.setString(2, inst);
				pstmt.setString(3, eDate);

				pstmt.executeUpdate();

			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 

		}
	}
	public void saveExperience(){
		String pos = "";
		String cmp = "";
		String sDate = "";
		String eDate = "";
		String dut = "";

		System.out.println("Do you have experiance?");
		if(addMore.equalsIgnoreCase(scn.nextLine())){
			hasNext = true;

			while (hasNext){
				isValid = false;
				Experience exp1 = new Experience();
				while(!isValid){
				System.out.println("Please Enter your position");
				pos = scn.nextLine();
				exp1.setPosition(pos);
				if (!pos.matches("[a-zA-Z_]+")) {
				    System.out.println("Invalid name");
				}else{
					isValid = true;
				}
				}
				isValid = false;
				
				while(!isValid){
				System.out.println("Please Enter the company name");
				cmp = scn.nextLine();
				exp1.setCompany(cmp);
				if (!cmp.matches("[a-zA-Z_]+")) {
				    System.out.println("Invalid name");
				}else{
					isValid = true;
				}
				}
				isValid = false;
				
				while(!isValid){
				System.out.println("Please Enter the start date");
				sDate = scn.nextLine();
				exp1.setStartDate(sDate);
				if (!eDate.matches("[0-9]+")) {
				    System.out.println("Invalid number");
				}else{
					isValid = true;
				}
				}
				isValid = false;
				
				while(!isValid){
				System.out.println("Please Enter the end date");
				eDate= scn.nextLine();
				exp1.setEndDate(eDate);
				if (!eDate.matches("[0-9]+")) {
				    System.out.println("Invalid number");
				}else{
					isValid = true;
				}
				}
				isValid = false;
				
				while(!isValid){
				System.out.println("Please Enter your duties");
				dut = scn.nextLine();
				exp1.getDuty().add((dut));
				if (!dut.matches("[a-zA-Z_]+")) {
				    System.out.println("Invalid name");
				}else{
					isValid = true;
				}
				} 
				
				String duty = "insert into duty(duty) values(?)";

				try{
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
							+ "user=root&password=password");

					PreparedStatement pstmt = con.prepareStatement(duty);
					pstmt.setString(1, dut);
					pstmt.executeUpdate();

				}catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				while(hasNext){
					System.out.println("Do you want to add another duty?");

					if(addMore.equalsIgnoreCase(scn.nextLine())){
						hasNext = true;
						dut = scn.nextLine();
						exp1.getDuty().add((dut));

						String duty2 = "insert into duty(duty) values(?,?)";

						try{
							Class.forName("com.mysql.jdbc.Driver");
							con= DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
									+ "user=root&password=password");

							PreparedStatement pstmt = con.prepareStatement(duty);
							pstmt.setString(1, dut);
							pstmt.executeUpdate();

						}catch (SQLException e) {
							e.printStackTrace();
						}catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

					} else {
						hasNext = false;
					}
				}
				experience.add(exp1);

				System.out.println("Do you want to add another experience?");

				if(addMore.equalsIgnoreCase(scn.nextLine())){
					hasNext = true;

				} else {
					hasNext = false;

				}


				System.out.println("");
				String exp = "insert into experience(startDate,endDate,company,position) values(?,?,?,?)";
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
							+ "user=root&password=password");

					PreparedStatement pstmt = con.prepareStatement(exp);
					pstmt.setString(1, sDate);
					pstmt.setString(2, eDate);
					pstmt.setString(3, cmp);
					pstmt.setString(4, pos);
					pstmt.executeUpdate();

				}catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}	
		}	 
		hasNext = true;
	}

	public void saveSkill(){
		String skl = "";
		String rating = "";
		System.out.println("Enter all your skills");
		while (hasNext){
			isValid = false;
			Skills sk = new Skills();
			while(!isValid){
			skl = scn.nextLine();
			sk.setSkill(skl);
			if (!skl.matches("[a-zA-Z_]+")) {
			    System.out.println("Invalid name");
			}else{
				isValid = true;
			}
			}
			System.out.println("How do you rate yourself for this skill [highly skilled, proficient,familiar]");
			rating = scn.nextLine();
			sk.setRating(rating);	

			scn.nextLine();
			skills.add(sk);

			System.out.println("Do you want to add another skill?");

			if(addMore.equalsIgnoreCase(scn.nextLine())){
				hasNext = true;

			} else {
				hasNext = false;


			}

			System.out.println("");

			String skill = "insert into skills(skill,rating) values(?,?)";

			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/Resumes?"
						+ "user=root&password=password");

				PreparedStatement pstmt = con.prepareStatement(skill);
				pstmt.setString(1, skl);
				pstmt.setString(2, rating);

				pstmt.executeUpdate();

			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 

		} 
	}

}


