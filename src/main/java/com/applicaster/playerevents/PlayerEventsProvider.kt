package com.applicaster.playerevents

import com.applicaster.plugin_manager.GenericPluginI

interface PlayerEventsProvider:GenericPluginI {

    fun onPlayerEvent(event: String, properties: Any)
}