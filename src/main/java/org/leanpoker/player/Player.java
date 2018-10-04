package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Random;

public class Player {

    static final String VERSION = "Default Java folding player";

    
    public static int betRequest(JsonElement request) {
    	
//    	JsonElement ja = ((JsonObject)request).get("players");
//    	for (JsonElement jp : ja.getAsJsonArray()) {
//			((JsonObject)jp).get();
//		}
//    	
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
