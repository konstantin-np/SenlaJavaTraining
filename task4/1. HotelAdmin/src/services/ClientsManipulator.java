package services;

import stores.ClientsStore;

public final class ClientsManipulator implements IClientsManipulator {
	
	public int getClientsCount(ClientsStore clients) {
		return clients.getAllClients().size();
	}
}
