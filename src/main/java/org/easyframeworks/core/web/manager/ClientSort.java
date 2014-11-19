package org.easyframeworks.core.web.manager;

import java.util.Comparator;

public class ClientSort implements Comparator<Client<?>> {

	
	public int compare(Client<?> prev, Client<?> now) {
		return (int) (now.getLogindatetime().getTime()-prev.getLogindatetime().getTime());
	}

}
