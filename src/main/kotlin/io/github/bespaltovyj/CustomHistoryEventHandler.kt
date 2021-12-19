package io.github.bespaltovyj

import org.camunda.bpm.engine.impl.history.event.HistoryEvent
import org.camunda.bpm.engine.impl.history.handler.HistoryEventHandler

class CustomHistoryEventHandler: HistoryEventHandler {

    fun handleEvent(historyEvent: HistoryEventProvider) {
        if (historyEvent is CustomHistoryEvent) {
            val businessKey = historyEvent.businessKey
            // TODO process custom history event
        }
    }

    override fun handleEvent(historyEvent: HistoryEvent) {
        TODO("Not yet implemented")
    }

    override fun handleEvents(historyEvents: MutableList<HistoryEvent>?) {
        TODO("Not yet implemented")
    }
}