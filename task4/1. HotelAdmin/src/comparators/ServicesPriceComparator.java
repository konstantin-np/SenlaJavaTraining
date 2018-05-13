package comparators;

import java.util.Comparator;

import models.Service;

public class ServicesPriceComparator implements Comparator<Service> {

	public int compare(Service s1, Service s2) {
		if (s1.getPrice() < s2.getPrice()) {
			return -1;
		}
        if (s1.getPrice() > s2.getPrice()) {
        	return 1;
        }
        return 0;
	}
	
}
