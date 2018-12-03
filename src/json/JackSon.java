package json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackSon {
	public static ObjectMapper jsonMapper = new ObjectMapper();

	public static void test1() throws JsonProcessingException {
		// 初始化jsonMap
		jsonMapper = new ObjectMapper();
		jsonMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);// 解析json对象忽略字符串包含非引号控制字符
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);// 解析json对象忽略未知属性
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		String str = jsonMapper.writeValueAsString(list);
		System.out.println(str);

	}

	/**
	 * beanTojson
	 * @throws JsonProcessingException
	 */
	public static void test2() throws JsonProcessingException {
		Friend f = new Friend();
		f.setAge(18);
		f.setNickname("张三");
		f.setDate(new Date());
		String str = jsonMapper.writeValueAsString(f);
		System.out.println(str);
	}
	/**
	 * 反序列化jsonToBean
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void test3() throws JsonParseException, JsonMappingException, IOException{
		String test1 = "{\"nickname\":\"张三\",\"age\":18,\"date\":1543836889297}";
		Friend friend = jsonMapper.readValue(test1, Friend.class);
		System.out.println(friend.getAge());
		System.out.println(friend.getNickname());
		System.out.println(friend.getDate());
	}

	/**
	 * jsonToMap
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	public static void test4() throws JsonParseException, JsonMappingException, IOException{
		String str = "{\"nickname\":\"张三\",\"age\":18,\"date\":1543837396943}";
		String test="{\"results\":[{\"objectID\":357,\"geoPoints\":[{\"x\":504604.59802246094,\"y\":305569.9150390625}]},{\"objectID\":358,\"geoPoints\":[{\"x\":504602.2680053711,\"y\":305554.43603515625}]}]}";
		Map<String, Object> map = jsonMapper.readValue(str, Map.class);
		Map<String, Object> map1 = jsonMapper.readValue(test, Map.class);
		System.out.println(map1);
	}
	
	public static void main(String[] args) throws IOException {
		test1();
		test2();
		test3();
		test4();
	}

}
