package io.github.bespaltovyj

import org.camunda.bpm.engine.impl.history.event.HistoryEvent

interface HistoryEventProvider {

    fun getHistoryEvent(): HistoryEvent?
}