package com.applicaster.playerevents;

import java.util.HashMap;

public interface PlayerEventsProvider {

    void onPlayerEvents(String event, HashMap<String,Object> properties);
}
