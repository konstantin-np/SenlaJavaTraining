package models;

public class Client {
	
	private String name;
	private int passportId;
	
	public Client(String name, int passportId) {
		this.name = name;
		this.passportId = passportId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
}
