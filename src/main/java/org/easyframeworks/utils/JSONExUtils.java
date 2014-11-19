package org.easyframeworks.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONExUtils extends ObjectMapper {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -2991544314764674159L;

	public String Object2Json(Object obj) {
		String json = null;
		try {
			json = this.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LoggerUtils.error("", e);
			e.printStackTrace();
		}
		return json;
	}
}
