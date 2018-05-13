package stores;

import java.util.List;

import models.Service;

public interface IServicesStore {
	
	public void addService(Service service);
	public void removeService(Service service);
	public Service getService(int idInList);
	public List<Service> getAllServices();
}
