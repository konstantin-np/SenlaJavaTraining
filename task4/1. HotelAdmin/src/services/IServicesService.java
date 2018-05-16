package services;

import java.util.List;

import models.Service;
import stores.ServicesStore;

public interface IServicesService {
	
	public void addService(ServicesStore services, Service service);
	public void removeService(ServicesStore services, Service service);
	public Service getService(ServicesStore services, int idInList);
	public List<Service> getAllServices(ServicesStore services);
	
}
