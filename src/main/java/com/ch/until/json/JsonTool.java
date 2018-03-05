package com.ch.until.json;


import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;


/*
 * json转换工具
 */
public class JsonTool {
	
	public static Map<String,Object> jsonToMap(String json){
		Map<String,Object> map = new HashMap<String, Object>(); 
		map = JSONObject.parseObject(json,Map.class);
		return map;
	}
}
