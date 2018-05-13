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

	public void addClient(Client client) {
		if (client != null) {
			this.clients.add(client);
		}
	}

	public void removeClient(Client client) {
		if (client != null) {
			this.clients.remove(client);
		}
	}

	public Client getClient(int idInList) {
		if (this.clients.size() > idInList) {
			return this.clients.get(idInList);
		} else {
			return null;
		}
	}

	public List<Client> getAllClients() {
		return this.clients;
	};
	
	
}
