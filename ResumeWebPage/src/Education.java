public class Education {
	
	private String typeOfDegree;
	private String institute;
	private String endDate;
	
	
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
	@Override
	public String toString() {
		return "Education [typeOfDegree=" + typeOfDegree + ", institute=" + institute + ", " + ", endDate="
				+ endDate + "]";
	}
	
	

}
