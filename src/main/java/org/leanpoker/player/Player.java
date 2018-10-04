package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Random;

public class Player {
    static final String VERSION = "Default Java folding player";
    
    public static int betRequest(JsonElement request) {
    	JsonElement ja = ((JsonObject)request).get("players");
    	int max = 0;
//    	
    	for (JsonElement jp : ja.getAsJsonArray()) {
			JsonElement jname = ((JsonObject)jp).get("name");
			if (jname.getAsString().contains("oker")) {
				JsonElement jst = ((JsonObject)jp).get("stack");
				//return jst.getAsInt();
			 }
			 
			JsonElement jbet = ((JsonObject)jp).get("bet");
			if (jbet.getAsInt() > max) {
				max = jbet.getAsInt();
			}
		}
//    	
        //return max;
    	//System.out.println("->"+max);
    	return max+1; 
    }

    public static void showdown(JsonElement game) {
    }
    
    String[] evalCards(JsonElement jWir) {
    	String[] ret = new String[2];
    	JsonElement hc = ((JsonObject)jWir).get("hole_cards");
    	ret[0] = hc.getAsJsonArray().get(0).getAsString();
    	ret[1] = hc.getAsJsonArray().get(0).getAsString();
    	
    	System.out.println(ret[0]);
    	System.out.println(ret[1]);
    	return ret;
    }
    
    
    
}
