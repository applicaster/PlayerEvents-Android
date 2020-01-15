package com.applicaster.playerevents;

import java.util.HashMap;

public interface PlayerEventsProvider {

    void onPlayerEvent(String event, HashMap<String,Object> properties);
}
