package services;

import java.util.List;

import models.Client;
import stores.ClientsStore;

public class ClientsService implements IClientsService {
	
	public int getClientsCount(ClientsStore clients) {
		return clients.getClients().size();
	}
	
	public void addClient(ClientsStore clients, Client client) {
		if (client != null) {
			clients.getClients().add(client);
		}
	}

	public void removeClient(ClientsStore clients, Client client) {
		if (client != null) {
			clients.getClients().remove(client);
		}
	}

	public Client getClient(ClientsStore clients, int idInList) {
		if (clients.getClients().size() > idInList) {
			return clients.getClients().get(idInList);
		} else {
			return null;
		}
	}

	public List<Client> getAllClients(ClientsStore clients) {
		return clients.getClients();
	};
}
