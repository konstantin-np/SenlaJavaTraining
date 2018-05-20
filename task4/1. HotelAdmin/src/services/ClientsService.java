package services;

import java.util.List;

import models.Client;
import stores.ClientsStore;

public class ClientsService implements IClientsService {
	
	ClientsStore clients;
	
	public ClientsService() {
		super();
		this.clients = new ClientsStore();
	}

	public ClientsStore getClients() {
		return clients;
	}

	public void setClients(ClientsStore clients) {
		this.clients = clients;
	}

	public int getClientsCount() {
		return this.clients.getClients().size();
	}
	
	public void addClient(Client client) {
		if (client != null) {
			this.clients.getClients().add(client);
		}
	}

	public void removeClient(Client client) {
		if (client != null) {
			this.clients.getClients().remove(client);
		}
	}

	public Client getClient(int idInList) {
		if (this.clients.getClients().size() > idInList) {
			return this.clients.getClients().get(idInList);
		} else {
			return null;
		}
	}

	public List<Client> getAllClients() {
		return this.clients.getClients();
	};
}
