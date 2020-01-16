package com.applicaster.playerevents

interface PlayerEventsProvider {

    fun onPlayerEvent(event: String, properties: Any)
}