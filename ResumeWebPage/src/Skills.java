

public class Skills {
	
	private String skill;
	private int rating;
	
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating2) {
		this.rating = rating2;
	}
	@Override
	public String toString() {
		return "Skills [skill=" + skill + ", rating=" + rating + "]";
	}
	
	
	
}
