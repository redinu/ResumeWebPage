
import java.util.ArrayList;
import java.util.Date;

public class Experience {
	
	private int experienceId; 
	private String startDate;
	private String endDate;
	private String position;
	private String company;
	private ArrayList<Duty> duty = new ArrayList<Duty>();
	
	
	public int getExperienceId() {
		return experienceId;
	}
	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public ArrayList<Duty> getDuty() {
		return duty;
	}
	public void setDuty(ArrayList<Duty> duty2) {
		this.duty = duty2;
	}
	@Override
	public String toString() {
		return "Experience [startDate=" + startDate + ", endDate=" + endDate + ", position=" + position + ", company="
				+ company + ", duty=" + duty + "]";
	}
	
	

}
