package fastjson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class FastJsonTest {
	//json字符串-简单对象型
	private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
	//json字符串-数组类型
	private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
	//复杂格式json字符串
	private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
	
	/**
     * json字符串-简单对象型与JSONObject之间的转换
     */
	public static void testJSONStrtoJSONObject(){
		JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
		System.out.println(jsonObject.getString("studentName"));
		System.out.println(jsonObject.getInteger("studentAge"));
	}
	
	/**
	 * json字符串-数组类型与JSONArray之间的转换
	 */
	public static void testJSONStrToJSONArray(){
		
		JSONArray jsonArray = JSON.parseArray(JSON_ARRAY_STR);
		int size = jsonArray.size();
		for(int i=0;i<size;i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			System.out.println(jsonObject.getString("studentName"));
			System.out.println(jsonObject.getInteger("studentAge"));
		}
	}
	
	/**
	 * 复杂json字符串与JSONObject之间的转换
	 */
	public static void testComlexJSONStrToJSONObject(){
		
		JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
		String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");
        System.out.println(teacherName);
        System.out.println(teacherAge);
        System.out.println(course);
        System.out.println(students);
	}
	
	/**
	 * json字符串-简单对象与JavaBean_Obj之间的转换
	 */
	public static void testJSONStrToJavaBeanObj(){
		
		Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>(){});
		System.out.println(student.getStudentName());
		System.out.println(student.getStudentAge());
	}
	
	/**
	 * json字符串-数组类型与JavaBean_List之间的转换
	 */
	public static void testJSONStrToJavaBeanList(){
		List<Student> students = JSON.parseObject(JSON_ARRAY_STR,new TypeReference<List<Student>>(){});
		for(Student student:students){
			System.out.println(student.getStudentName());
			System.out.println(student.getStudentAge());
		}
	}
	
	/**
     * 复杂json格式字符串与JavaBean_obj之间的转换
     */
    public static void testComplexJSONStrToJavaBean(){

        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName();
        Integer teacherAge = teacher.getTeacherAge();
        Course course = teacher.getCourse();
        List<Student> students = teacher.getStudents();
    }
	
	
	
	public static void main(String[] args) {
		//testJSONStrtoJSONObject();
		//testJSONStrToJSONArray();
		//testComlexJSONStrToJSONObject();
		//testJSONStrToJavaBeanObj();
		testJSONStrToJavaBeanList();
	}
	
}
