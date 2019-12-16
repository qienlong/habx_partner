package cn.com.sinosafe.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Copy Right Information : Forms Syntron <br>
 * Project : 华安 Java EE ????平台 <br>
 * Description : JSON格式处理相关工具??br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2015-10-6<br>
 */
public class JSONUtils {
	
	private JSONUtils(){
	}
	
	private static JSONUtils json = null;
	
	private static ObjectMapper mapper = null;
	
	public static JSONUtils getSingleInstance() {
		if(null == json){
			synchronized(JSONUtils.class){
				if(null == json){
					json = new JSONUtils();
				}
			}
		}
		return json;
	}
	
	/**
	 * 获取全局ObjectMapper实例
	 * @return
	 */
	public ObjectMapper getGlobalMapper()
	{
		if(null == mapper){
			synchronized(ObjectMapper.class)
			{
				if(null == mapper)
				{
					mapper = getLocalMapper();
				}
			}
		}
		return mapper;
	}
	
	/**
	 * 获取????ObjectMapper实例
	 * @return
	 */
	public ObjectMapper getLocalMapper()
	{
		return  new ObjectMapper()
				.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)		// 允许使用单引??
			 	.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true) // 允许字段名不用引??
			 	.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) // 允许字段名不用引??
			 	.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)//忽略字符串有java中没有的属??
			 	;
	}
	
	/**
	 * 使用泛型方法，把json字符串转换为相应的JavaBean对象??
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	public <T> T readValue(String jsonStr, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		return this.getGlobalMapper().readValue(jsonStr, valueType);
	}
	
	/**
	 * json数组转List
	 * @param jsonStr
	 * @param valueTypeRef
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef) throws JsonParseException, JsonMappingException, IOException{
		return this.getGlobalMapper().readValue(jsonStr, valueTypeRef);
	}

	/**
	 * 把JavaBean转换为json字符??
	 * 
	 * @param object
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public String toJSon(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		return this.getGlobalMapper().writeValueAsString(object);
	}
	
	/**
	 * 将Json字符串转变为Map<String, Object>
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Map<String, Object> readMapValue(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		return this.getGlobalMapper().readValue(jsonString, new TypeReference<Map<String, Object>>(){});
	}
	
	/**
	 * 将Json字符串转变为Map<String, Object>
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Map<String, String> readMapValue_(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		return this.getGlobalMapper().readValue(jsonString, new TypeReference<Map<String, String>>(){});
	}
	
	/**
	 * 将Json字符串转变为List<Map<String, Object>>
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Map<String, Object>> readListMapValue(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		return this.getGlobalMapper().readValue(jsonString, new TypeReference<List<Map<String, Object>>>(){});
	}
	
	/**
     * List<T> 转 JSON
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * JSON 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }
}
