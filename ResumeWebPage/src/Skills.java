

public class Skills {
	
	private int skillId;
	private String skill;
	private String rating;
	
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating2) {
		this.rating = rating2;
	}
	@Override
	public String toString() {
		return "Skills [skill=" + skill + ", rating=" + rating + "]";
	}
	
	
	
}
