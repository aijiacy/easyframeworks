package org.easyframeworks.core.entity;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.easyframeworks.core.web.manager.Client;
import org.easyframeworks.core.web.manager.ClientManager;
import org.easyframeworks.utils.ReflectHelper;

public class FillUpEntity<T> {
	public void fillUp(T entity, HttpSession session) {
		ReflectHelper fillObject = new ReflectHelper(entity);
		Date currDate = new Date();
		fillObject.setMethodValue("createDate", currDate);
		Client<?> client = ClientManager.getInstance().getClient(session.getId());
		if (client != null) {
			ReflectHelper readObject = new ReflectHelper(entity);
			Integer userId = Integer.parseInt(readObject.getMethodValue("id").toString());
			fillObject.setMethodValue("createUser", userId);
		}
	}
}
