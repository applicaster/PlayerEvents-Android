package com.applicaster.playerevents;

import com.applicaster.player.Player;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class test {


    test(){
        PlayerEventsManager.INSTANCE.onPlayerEvent("heartbeat",new HashMap<String,Object>().put("elapsed_time",2000));
    }

}
