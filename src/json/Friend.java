package json;

import java.util.Date;

public class Friend {
	
	private String nickname;
	private int age;
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Friend [nickname=" + nickname + ", age=" + age + ", date="
				+ date + "]";
	}
	
	

}
