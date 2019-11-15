package vo;

public class FormVO {
	private String id;
	private String password;
	private String gender;
	private String command;
	private String tel;	
	private String intro;
	public FormVO(String id, String password, String gender, String command, String tel, String intro) {
		super();
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.command = command;
		this.tel = tel;
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "FormVO [id=" + id + ", password=" + password + ", gender=" + gender + ", command=" + command + ", tel="
				+ tel + ", intro=" + intro + "]";
	}	
	
}
