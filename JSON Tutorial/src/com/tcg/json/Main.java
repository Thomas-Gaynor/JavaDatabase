package com.tcg.json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import org.json.*;

public class Main {

	public static void main(String[] args) {
		
		
		String path = "/data.json";
		JSONObject obj = JSONUtils.getJSONObjectFromFile(path);
		String[] names = JSONObject.getNames(obj);
		
		JSONArray jsonArray = obj.getJSONArray("Students");
//		for(int i = 0; i < jsonArray.length(); i++) {
//			JSONObject tempStudent = (JSONObject) jsonArray.get(i);
//			System.out.println(tempStudent);
//			//tempStudent.put("firstName", "FML");	
//		}
		
		searchThroughJSONArray(jsonArray, "firstName", "Thomas").put("present", true);

		try(FileWriter file = new FileWriter("assets/data.json")){
			file.write(obj.toString());
			file.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static JSONObject searchThroughJSONArray(JSONArray jsonArray, String property, String data){
		
		for(int i = 0; i < jsonArray.length(); i++) {
			
			JSONObject temp = (JSONObject) jsonArray.get(i);
			
			if(temp.get(property).equals(data)) {
				
				return temp;
				
			}
			
		}
		return null;
	}
	
}
