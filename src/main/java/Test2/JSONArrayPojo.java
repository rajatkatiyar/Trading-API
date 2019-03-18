package Test2;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONArrayPojo {
static JSONArray ja;

	
	
	public static void setJa(JSONArray ja) {
		
		JSONArrayPojo.ja = ja;
	}
	
	public static void setJo(JSONObject jo) {
	
		JSONArrayPojo.ja.put(jo);
		System.out.println(ja.toString());
	}
	public static JSONArray getJa() {
		System.out.println("BBBBBBBBBBBBBBBBBBB--------gset Ja-----------------------------MMMMMMMM");
		System.out.println(ja.toString());

		return JSONArrayPojo.ja;
	}
}
