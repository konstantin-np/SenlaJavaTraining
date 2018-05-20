package services;

import java.util.ArrayList;
import java.util.List;

import models.Client;
import models.Order;
import models.Service;
import stores.ServicesStore;

public class ServicesService implements IServicesService {
	
	ServicesStore services;
	
	public ServicesService() {
		this.services = new ServicesStore();
	}
	
	public ServicesStore getServices() {
		return services;
	}

	public void setServices(ServicesStore services) {
		this.services = services;
	}

	public void addService(Service service) {
		this.services.getServices().add(service);
	}

	public void removeService(Service service) {
		this.services.getServices().remove(service);
	}

	public Service getService(int idInList) {
		return this.services.getServices().get(idInList);
	}

	public List<Service> getAllServices() {
		return this.services.getServices();
	}
	
}
