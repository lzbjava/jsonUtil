package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
	/**
	 * java对象转JSON字符串
	 */
	public static void test1(){
		Friend f = new Friend();
		f.setAge(20);
		f.setNickname("张三");
		JSONObject jsonObj = JSONObject.fromObject(f);
		String jsonStr = jsonObj.toString();
		System.out.println(jsonStr);
	}
	/**
	 * JAVA数组(集合)转换为JSON字符串
	 */
	public static void test2(){
		List<Friend> fs = new ArrayList<Friend>();
		for(int i=0;i<3;i++){
			Friend f = new Friend();
			f.setAge(18);
			f.setNickname("李四");
			fs.add(f);
		}
		JSONArray jsonArr = JSONArray.fromObject(fs);
		String jsonStr = jsonArr.toString();
		System.out.println(jsonStr);
		
	}
	
	/**
	 * JSON字符串转为JAVA对象
	 */
	public static void test3(){
		String jsonStr = "{\"age\":20,\"nickname\":\"张三\"}";
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		Friend friend = (Friend) JSONObject.toBean(jsonObj,Friend.class);
		System.out.println(friend);
	}
	
	/**
	 * JSON字符串转换为JAVA数组(集合)
	 * @param args
	 */
	
	public static void test4(){
		String jsonStr = "[{\"age\":18,\"nickname\":\"李四\"},{\"age\":18,\"nickname\":\"李四\"},{\"age\":18,\"nickname\":\"李四\"}]";
		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		@SuppressWarnings("unchecked")
		List<Friend> friends = (List<Friend>) JSONArray.toCollection(jsonArr, Friend.class);
		for(Friend f:friends){
			System.out.println(f);
		}
	}
	
	
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

}
