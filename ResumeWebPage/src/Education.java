public class Education {
	
	private String typeOfDegree;
	private String institute;
	private String endDate;
	private int educationId;
	private Person person;
	
	
	
	public int getEducationId() {
		return educationId;
	}
	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}
	public String getTypeOfDegree() {
		return typeOfDegree;
	}
	public void setTypeOfDegree(String typeOfDegree) {
		this.typeOfDegree = typeOfDegree;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Education [typeOfDegree=" + typeOfDegree + ", institute=" + institute + ", " + ", endDate="
				+ endDate + "]";
	}
	
	

}
