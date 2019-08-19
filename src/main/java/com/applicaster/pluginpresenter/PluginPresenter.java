package com.applicaster.pluginpresenter;

import android.app.Activity;

import com.applicaster.plugin_manager.GenericPluginI;

/**
 Interface to allow to present a plugin and wait for a response in that plugin.
 Using this protocol you can present in your plugin another plugin and take a result from there.
 This is useful to present other plugins, or to insert a screen between the flow of another plugin.
 */
public interface PluginPresenter extends GenericPluginI {

    /**
     * Request code used inside onActivityResult.
     * Use this request code in the implementation of presentPlugin when calling startActivityForResult.
     */
    int PLUGIN_PRESENTER_REQUEST_CODE = 10000;

    /**
     * Call this method when you want to present the plugin.
     *
     * @param activity: Activity used to present the plugin that will implement onActivityResult.
     * @param extraData: Optional data to pass extra information.
     */
    void presentPlugin(Activity activity, Object extraData);
}
