
public class User {
	
	private String name;
	private String emailId;
	private int buisnessId;
	
	public User() {}
	
	public User(String name, String emailId, int buisnessId) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.buisnessId = buisnessId;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getEmailId() {
		return emailId;
	}
	protected void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	protected int getBuisnessId() {
		return buisnessId;
	}
	protected void setBuisnessId(int buisnessId) {
		this.buisnessId = buisnessId;
	}
	
	

}
