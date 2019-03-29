package others;

public class User {

	private String email;
	private String userName;
	private String password;
	private boolean isPremium;
	private boolean isAdmin;
	
	public User() {
		
	}
	public User(String email, String userName, String password, boolean isPremium, boolean isAdmin) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.isPremium = isPremium;
		this.isAdmin = isAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + ", isPremium=" + isPremium
				+ ", isAdmin=" + isAdmin + "]";
	}

	
	

}
