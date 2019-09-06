package spring;

public class RegisterRequest {
	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPpassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmpassword) {
		this.confirmPassword = confirmpassword;
	}

	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
}
