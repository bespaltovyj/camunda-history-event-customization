package io.github.bespaltovyj

import org.camunda.bpm.engine.impl.history.parser.*
import org.camunda.bpm.engine.impl.history.producer.HistoryEventProducer

class CustomHistoryParseListener(
    historyEventProducer: HistoryEventProducer
) : HistoryParseListener(historyEventProducer) {

    init {
        PROCESS_INSTANCE_START_LISTENER = ProcessInstanceStartListener(historyEventProducer)
        PROCESS_INSTANCE_END_LISTENER = ProcessInstanceEndListener(historyEventProducer)

        // replace default activity start listener
        ACTIVITY_INSTANCE_START_LISTENER = CustomActivityInstanceStartListener(historyEventProducer)
        ACTIVITY_INSTANCE_END_LISTENER = ActivityInstanceEndListener(historyEventProducer)

        USER_TASK_ASSIGNMENT_HANDLER = ActivityInstanceUpdateListener(historyEventProducer)
        USER_TASK_ID_HANDLER = USER_TASK_ASSIGNMENT_HANDLER
    }

    override fun initExecutionListeners(historyEventProducer: HistoryEventProducer) = Unit
}