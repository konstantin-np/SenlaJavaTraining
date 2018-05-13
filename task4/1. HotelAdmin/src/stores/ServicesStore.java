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

	public void addService(Service service) {
		this.services.add(service);
	}

	public void removeService(Service service) {
		this.services.remove(service);
	}

	public Service getService(int idInList) {
		return this.services.get(idInList);
	}

	public List<Service> getAllServices() {
		return this.services;
	}
	
}
