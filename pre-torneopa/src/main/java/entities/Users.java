package entities;

public class Users {
	private String name;	
	private String email;
	private int idUser;
	public Users(String name, String email, int idUser) {
		super();
		this.name = name;
		this.email = email;
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", idUser=" + idUser + "]";
	}
	
}
