package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {
    static final String VERSION = "Default Java folding player";
    
    public static int betRequest(JsonElement request) {
    	JsonElement ja = ((JsonObject)request).get("players");
    	
    	int round = ((JsonObject)request).get("round").getAsInt();
    	int max = 0;
    	int active = 0;
//    	
    	for (JsonElement jp : ja.getAsJsonArray()) {
			JsonElement jname = ((JsonObject)jp).get("name");
			if (jname.getAsString().contains("oker")) {
				//JsonElement jst = ((JsonObject)jp).get("stack");
				//return jst.getAsInt();
				//--hole_cards(jp);
			 }
			 
			JsonElement jbet = ((JsonObject)jp).get("bet");
			if (jbet.getAsInt() > max) {
				max = jbet.getAsInt();
			}
			
			JsonElement jactive = ((JsonObject)jp).get("status");
			if (! "out".equals(jactive.getAsString())) {
				active++;
			}
		}
    	
    	//community_cards(request);
    	if (active <= 2)
    		return max+1;
    	return 0;
    }

    public static void showdown(JsonElement game) {
    }
    

    static String[] hole_cards(JsonElement jWir) {
    	String[] ret = new String[4];
    	JsonElement hc = ((JsonObject)jWir).get("hole_cards");
    	
    	ret[0] = ((JsonObject)hc.getAsJsonArray().get(0)).get("rank").getAsString();
    	ret[1] = ((JsonObject)hc.getAsJsonArray().get(0)).get("suit").getAsString();
      	ret[2] = ((JsonObject)hc.getAsJsonArray().get(1)).get("rank").getAsString();
    	ret[3] = ((JsonObject)hc.getAsJsonArray().get(1)).get("suit").getAsString();
    	
    	return ret;
    }

    
    static String[] community_cards(JsonElement jo) {
    	String[] ret = new String[6];
    	JsonElement hc = ((JsonObject)jo).get("community_cards");
    	
    	ret[0] = ((JsonObject)hc.getAsJsonArray().get(0)).get("rank").getAsString();
    	ret[1] = ((JsonObject)hc.getAsJsonArray().get(0)).get("suit").getAsString();
      	ret[2] = ((JsonObject)hc.getAsJsonArray().get(1)).get("rank").getAsString();
    	ret[3] = ((JsonObject)hc.getAsJsonArray().get(1)).get("suit").getAsString();
      	ret[4] = ((JsonObject)hc.getAsJsonArray().get(2)).get("rank").getAsString();
    	ret[5] = ((JsonObject)hc.getAsJsonArray().get(2)).get("suit").getAsString();
    	
    	return ret;
    }
    
    
    
}
