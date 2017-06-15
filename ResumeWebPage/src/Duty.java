
public class Duty {
	
	private String dutyId;
	private String duty;
	private Experience ex;
	
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Experience getEx() {
		return ex;
	}
	public void setEx(Experience ex) {
		this.ex = ex;
	}
	@Override
	public String toString() {
		return  duty ;
	}
	
	

}
