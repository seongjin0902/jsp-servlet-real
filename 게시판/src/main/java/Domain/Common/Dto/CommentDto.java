package Domain.Common.Dto;

public class CommentDto {
	private int No;
	private int number; 
	private String id;
	private String comment;
	private String date;


	//	디폴트 생성자
	public CommentDto() {}
	
//	모든 인자를 받는 생성자
	public CommentDto(int No, int number, String id, String comment, String date) {
		this.No = No;
		this.number=number;
		this.id = id;
		this.comment = comment;
		this.date = date;
	}
//	toString 재정의
	@Override
	public String toString() {
		return "CommentDto [No=" + No + ", number=" + number + ",id=" + id + ", comment=" + comment + ", date=" + date + "]";
	}
	

//	getter and setter
	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
	