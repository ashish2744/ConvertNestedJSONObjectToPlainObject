package com.example.converter;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
public class JSONConverter {
	
	private static final String jsonRequest = "{\r\n"
			+ "\"record\":\r\n"
			+ "    {\r\n"
			+ "    \"CUACCC\": \" \",\r\n"
			+ "    \"CUACCR\": \" \",\r\n"
			+ "    \"CUACPC\": \" \",\r\n"
			+ "    \"CUADR1\": \"86 BEDFORD ST \",\r\n"
			+ "    \"CUADR2\": \" \",\r\n"
			+ "    \"CUADR3\": \" \",\r\n"
			+ "    \"CUADR4\": \" \",\r\n"
			+ "    \"CUAGC\": \"TRDAG\",\r\n"
			+ "    \"CUAICD\": \"1\",\r\n"
			+ "    \"CUALIA\": \" \",\r\n"
			+ "    \"RRN_FIELD_DATA\": 92435.0\r\n"
			+ "    },\r\n"
			+ "\"sv_file_member\": \"ARPCU\",\r\n"
			+ "\"sv_job_name\": \"RBLP020150\",\r\n"
			+ "\"sv_job_number\": \"464307\",\r\n"
			+ "\"sv_journal_seqno\": \"00000000000104898535\",\r\n"
			+ "\"sv_manip_type\": \"U\"\r\n"
			+ "}";
	
	public void convertNestedToPlainJSON() {
		JSONObject jsonObject = JSON.parseObject(jsonRequest);
		Map<String, Object> map = (Map<String, Object>) jsonObject.get("record");
		jsonObject.remove("record");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			jsonObject.put(entry.getKey(), entry.getValue());
		}

		jsonObject.remove("record"); 
		System.out.println(jsonObject);

	}

}
