
public class Client extends Person {
	
	private int passportId;
	
	public Client(String name, int passportId) {
		super(name);
		this.passportId = passportId;
	}
	
	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	

	
	
	
}
