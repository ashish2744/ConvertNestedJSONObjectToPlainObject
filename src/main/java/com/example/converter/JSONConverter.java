package com.example.converter;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
public class JSONConverter {

	private static final String jsonRequest = "{\r\n"
			+ "\"address\":\r\n"
			+ "    {\r\n"
			+ "    \"addressLine1\": \"24\",\r\n"
			+ "    \"addressLine2\": \"AMBEDKAR ROAD \",\r\n"
			+ "    \"addressLine3\": \" \",\r\n"
			+ "    \"city\": \"GHAZIABAD\",\r\n"
			+ "    \"state\": \"UP\",\r\n"
			+ "    \"zipCode\": \"201014\",\r\n"
			+ "    \"country\": \"INDIA\"\r\n"
			+ "    },\r\n"
			+ "\"firstName\": \"Ajay\",\r\n"
			+ "\"middleName\": \"Kumar\",\r\n"
			+ "\"lastName\": \"Sharma\",\r\n"
			+ "\"designation\": \"Senior Application Developer\",\r\n"
			+ "\"email\": \"example@gmail.com\"\r\n"
			+ "}";

	public void convertNestedToPlainJSON() {
		JSONObject jsonObject = JSON.parseObject(jsonRequest);
		Map<String, Object> map = (Map<String, Object>) jsonObject.get("address");
		jsonObject.remove("address");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			jsonObject.put(entry.getKey(), entry.getValue());
		}
		System.out.println(jsonObject);
	}

}
