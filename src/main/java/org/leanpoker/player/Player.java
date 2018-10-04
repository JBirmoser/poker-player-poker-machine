package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.Map;
import java.util.Random;

public class Player {

    static final String VERSION = "Default Java folding player";

    static Random r = new Random();
    
    public static int betRequest(JsonElement request) {
    	
        return r.nextInt() % 10;
    }

    public static void showdown(JsonElement game) {
    }
}
