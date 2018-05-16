package stores;

import java.util.ArrayList;
import java.util.List;

import models.Client;

public class ClientsStore implements IClientsStore{
	
	private List<Client> clients;
	
	public ClientsStore() {
		clients = new ArrayList<Client>();
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	
}
