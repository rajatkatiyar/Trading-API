package Test2;

import org.json.JSONArray;
import org.json.JSONObject;


public class JSONArrayExecutionPOJO {
static JSONArray ja;

	
	
	public static void setJa(JSONArray ja) {
		
		JSONArrayExecutionPOJO.ja = ja;
	}
	
	public static void setJo(JSONObject jo) {
	
		JSONArrayExecutionPOJO.ja.put(jo);
		System.out.println(ja.toString());
	}
	public static JSONArray getJa() {
		System.out.println("BBBBBBBBBBBBBBBBBBB--------gset Ja-----------------------------MMMMMMMM");
		System.out.println(ja.toString());

		return JSONArrayExecutionPOJO.ja;
	}
}
