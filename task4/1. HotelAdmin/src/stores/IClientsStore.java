package stores;

import java.util.List;

import models.Client;

public interface IClientsStore {
	
	public void addClient(Client client);
	public void removeClient(Client client);
	public Client getClient(int idInList);
	public List<Client> getAllClients();
	
}
