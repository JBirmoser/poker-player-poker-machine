package org.leanpoker.player;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {
    static final String VERSION = "Default Java folding player";
    
    public static int betRequest(JsonElement request) {
    	JsonElement ja = ((JsonObject)request).get("players");
    	
    	int round = ((JsonObject)request).get("round").getAsInt();
    	int max = 0;
    	int active = 0;
    	int stack = 0;
    	int betFromEdge = 0;
    	boolean sameRank = false;
    	String[] hole_ranks = new String[1];
//    	
    	for (JsonElement jp : ja.getAsJsonArray()) {
			JsonElement jname = ((JsonObject)jp).get("name");
			if (jname.getAsString().contains("oker")) {
				JsonElement jst = ((JsonObject)jp).get("stack");
				stack = jst.getAsInt();
				hole_ranks = hole_cards(jp);
				sameRank = hole_ranks[0].equals(hole_ranks[1]);
			 }
			 
			JsonElement jbet = ((JsonObject)jp).get("bet");
			if (jbet.getAsInt() > max) {
				max = jbet.getAsInt();
			}
			
			JsonElement jactive = ((JsonObject)jp).get("status");
			if (! "out".equals(jactive.getAsString())) {
				active++;
			}
			
//			if (jname.getAsString().contains("dge")) {
//				JsonElement jst = ((JsonObject)jp).get("bet");
//				betFromEdge = jst.getAsInt();
//			 }
		}
    	
    	if(sameRank) {
    		return stack;
    	}
    	
    	
    	
    	String[] community_cards = community_cards(request);
    	if(community_cards.length > 1 
    			&& containsSameRankWithCount(community_cards, hole_ranks, 3)) {
    		return max+1;
    	}
    	return 0;
    		
//    	if (active <= 4)
    		
//    	return 0;
    }

    private static boolean containsSameRankWithCount(String[] community_cards, 
    		String[] hole_ranks, 
    		int i) {
    	Map<String, Integer> rankCounts = new HashMap<>();
		for (int j = 0; j < hole_ranks.length; j++) {
			if(rankCounts.containsKey(hole_ranks[j])) {
				return true;
			}
			rankCounts.put(hole_ranks[j], 1);
		}
		return false;
	}

	public static void showdown(JsonElement game) {
    }
    

    static String[] hole_cards(JsonElement jWir) {
    	String[] ret = new String[2];
    	JsonElement hc = ((JsonObject)jWir).get("hole_cards");
    	
    	ret[0] = ((JsonObject)hc.getAsJsonArray().get(0)).get("rank").getAsString();
    	//ret[1] = ((JsonObject)hc.getAsJsonArray().get(0)).get("suit").getAsString();
      	ret[1] = ((JsonObject)hc.getAsJsonArray().get(1)).get("rank").getAsString();
    	//ret[3] = ((JsonObject)hc.getAsJsonArray().get(1)).get("suit").getAsString();
    	
    	return ret;
    }

    
    static String[] community_cards(JsonElement jo) {
    	String[] ret = new String[3];
    	JsonElement hc = ((JsonObject)jo).get("community_cards");
    	
    	ret[0] = ((JsonObject)hc.getAsJsonArray().get(0)).get("rank").getAsString();
//    	ret[1] = ((JsonObject)hc.getAsJsonArray().get(0)).get("suit").getAsString();
      	ret[1] = ((JsonObject)hc.getAsJsonArray().get(1)).get("rank").getAsString();
//    	ret[3] = ((JsonObject)hc.getAsJsonArray().get(1)).get("suit").getAsString();
      	ret[2] = ((JsonObject)hc.getAsJsonArray().get(2)).get("rank").getAsString();
//    	ret[5] = ((JsonObject)hc.getAsJsonArray().get(2)).get("suit").getAsString();
    	
    	return ret;
    }
    
    
    
}
