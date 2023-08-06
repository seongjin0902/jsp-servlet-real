package Domain.Common.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String role;
	private String name;
	private String phone;
	private String birth;

//	기본 생성자
	public MemberDto() {
	}

//	모든 인자를 받는 생성자
	public MemberDto(String id, String pw, String role, String name, String phone, String birth) {
		this.id = id;
		this.pw = pw;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}


// 	role인자를 뺀 생성자
	public MemberDto(String id, String pw, String name, String phone, String birth) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}


//	toString 재정의
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", role=" + role + ", name=" + name + ", phone=" + phone
				+ ", birth=" + birth + "]";
	}



//	getter and setter
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

}