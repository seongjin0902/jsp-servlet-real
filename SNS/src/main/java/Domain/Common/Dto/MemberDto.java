package Domain.Common.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String username;
	private String phone;
	private String birth;
	private String role;
	
	public MemberDto(){}
	public MemberDto(String id, String pw, String username, String role, String birth, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.username = username;
		this.role = role;
		this.birth = birth;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", username=" + username + ", phone=" + phone + ", birth=" + birth
				+ ", role=" + role + "]";
	}


	//기본생성자
	//모든인자 생성자
	//ToString
	//Getter and Setter
	
}