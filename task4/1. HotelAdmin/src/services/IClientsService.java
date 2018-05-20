package services;

import java.util.List;

import models.Client;
import stores.ClientsStore;

public interface IClientsService {
	
	public void addClient(Client client);
	public void removeClient(Client client);
	public Client getClient(int idInList);
	public List<Client> getAllClients();
	
	public int getClientsCount();
	
}
