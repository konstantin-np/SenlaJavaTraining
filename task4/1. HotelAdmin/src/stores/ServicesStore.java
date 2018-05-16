package stores;

import java.util.ArrayList;
import java.util.List;

import models.Service;

public class ServicesStore implements IServicesStore {
	
	private List<Service> services;
	
	public ServicesStore() {
		this.services = new ArrayList<Service>();;
	}
	
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	
	
}
