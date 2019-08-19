# PluginPresenter - Android
## OVERVIEW

Interface to allow to present an Applicaster plugin and wait for a response in that plugin.
Using this protocol you can present in your plugin another plugin and take a result from there. This is useful to present modally other plugins, or to insert a screen between the flow of another plugin.

## IMPLEMENTATION EXAMPLE

#### Calling plugin

Here is an example on how to implement the call to present a plugin.

``` java
PluginManager.InitiatedPlugin myPlugin = PluginManager.getInstance().getInitiatedPlugin("my_plugin_identifier");
if (myPlugin != null && myPlugin.instance instanceof PluginPresenter) {
    ((PluginPresenter) myPlugin.instance).setPluginModel(myPlugin.plugin);
    ((PluginPresenter) myPlugin.instance).presentPlugin(this, myExtraData);
}

// {. . .}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == PLUGIN_PRESENTER_REQUEST_CODE) {
        if (resultCode == RESULT_OK) {
            //Handle success
        }else {
            //Handle failure
        }
    }
}
```

#### Receiver plugin

Here is an example on how to implement the plugin that will be presented.

``` java
public class MyPlugin implements PluginPresenter {
    @Override
    public void presentPlugin(Activity activity, Object extraData) {
        Intent intent = new Intent(activity, MyPlugin.class);
        activity.startActivityForResult(intent, PLUGIN_PRESENTER_REQUEST_CODE);
    }

    @Override
    public void setPluginModel(Plugin plugin) {
        //Handle plugin configuration and other data
    }
}
```

And remember to call setResult for the activity result in some point of your code.

``` java
Intent returnIntent = new Intent();
setResult(RESULT_OK, returnIntent);
finish();
```