package io.github.bespaltovyj

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.impl.history.parser.ActivityInstanceStartListener
import org.camunda.bpm.engine.impl.history.producer.HistoryEventProducer

class CustomActivityInstanceStartListener(
    historyEventProducer: HistoryEventProducer
) : ActivityInstanceStartListener(historyEventProducer) {

    fun createCustomHistoryEvent(execution: DelegateExecution): CustomHistoryEvent? {
        return createHistoryEvent(execution)?.let {
            CustomHistoryEvent(
                it,
                execution.businessKey
            )
        }
    }
}