package services;

import java.util.List;

import models.Service;
import stores.ServicesStore;

public interface IServicesService {
	
	public void addService(Service service);
	public void removeService(Service service);
	public Service getService(int idInList);
	public List<Service> getAllServices();
	
}
