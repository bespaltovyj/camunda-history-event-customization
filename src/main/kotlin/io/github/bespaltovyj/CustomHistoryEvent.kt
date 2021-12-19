package io.github.bespaltovyj

import org.camunda.bpm.engine.impl.history.event.HistoryEvent

class CustomHistoryEvent(
    val event: HistoryEvent,
    val businessKey: String?
): HistoryEventProvider {

    override fun getHistoryEvent(): HistoryEvent? {
       return event
    }
}