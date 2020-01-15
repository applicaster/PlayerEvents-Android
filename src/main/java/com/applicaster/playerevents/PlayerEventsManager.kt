package com.applicaster.playerevents

import com.applicaster.plugin_manager.PluginManager

object PlayerEventsManager {

    var playerEventsProviders = mutableListOf<PlayerEventsProvider>()
    private set

    init {
        val pluginModels : List<PluginManager.InitiatedPlugin> ?= PluginManager.getInstance().allInitiatedPlugins

        pluginModels?.forEach { pluginModel ->
            val initiatedPlugin:PluginManager.InitiatedPlugin ?= PluginManager.getInstance().getInitiatedPlugin(pluginModel.plugin.identifier)
            if (initiatedPlugin is PlayerEventsProvider) playerEventsProviders.add(initiatedPlugin)
        }
    }

    fun onPlayerEvent(event: String, properties: HashMap<String,Any>) {
        playerEventsProviders.forEach { it.onPlayerEvent(event,properties) }
    }

}