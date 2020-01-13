# PluginPresenter - Android
## OVERVIEW

A PlayerEventsProvider is a plugin that listen to different notifications that the player can trigger and execute logic according to them.

A typical use case is to implement a continue watching system, where the player will trigger events of where the position of the stream is during the reproduction of a video, and the PlayerEventsProvider plugin listen to these notifications to communicate the position of the stream to a backend. Then the DSP (or another plugin) can request from the backend the position of the stream of a video and append in the extensions dictionary. The player plugin will read from the extension and will launch the player in that certain point in time.

## IMPLEMENTATION EXAMPLE

add dependency to the plugin

``` java
implementation ("com.applicaster:PlayerEvents-Android:0.0.+")
```
call the playerEvents singleton instance from some Plugin

``` java
PlayerEventsManager.INSTANCE.onPlayerEvent("heartbeat",new HashMap<String,Object>().put("elapsed_time",2000));
```

And here is how to implement the PlayerEventsProvider interface

``` java
public class testClass implements PlayerEventsProvider {

    @Override
    public void onPlayerEvent(@NotNull String event, @NotNull Object properties) {
        // Your logic to handle that event
    }

    @Override
    public void setPluginModel(Plugin plugin) {

    }
}
```