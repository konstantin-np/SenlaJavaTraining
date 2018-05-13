package comparators;

import java.util.Comparator;

import models.Client;

public class ClientsNameComparator implements Comparator<Client>{

	public int compare(Client c1, Client c2) {
		return c1.getName().compareTo(c2.getName());
	}
	
	
}
