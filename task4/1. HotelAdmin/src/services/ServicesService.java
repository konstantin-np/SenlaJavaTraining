package services;

import java.util.ArrayList;
import java.util.List;

import models.Client;
import models.Order;
import models.Service;
import stores.ServicesStore;

public class ServicesService implements IServicesService {
	
	public void addService(ServicesStore services, Service service) {
		services.getServices().add(service);
	}

	public void removeService(ServicesStore services, Service service) {
		services.getServices().remove(service);
	}

	public Service getService(ServicesStore services, int idInList) {
		return services.getServices().get(idInList);
	}

	public List<Service> getAllServices(ServicesStore services) {
		return services.getServices();
	}
	
}
