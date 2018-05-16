package services;

import java.util.List;

import models.Client;
import stores.ClientsStore;

public interface IClientsService {
	
	public void addClient(ClientsStore clients, Client client);
	public void removeClient(ClientsStore clients, Client client);
	public Client getClient(ClientsStore clients, int idInList);
	public List<Client> getAllClients(ClientsStore clients);
	
	public int getClientsCount(ClientsStore clients);
	
}
