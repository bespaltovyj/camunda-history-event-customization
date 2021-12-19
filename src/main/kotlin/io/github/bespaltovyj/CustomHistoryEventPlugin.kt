package io.github.bespaltovyj

import org.camunda.bpm.engine.ProcessEngine
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin
import org.camunda.bpm.engine.impl.history.producer.CacheAwareHistoryEventProducer

class CustomHistoryEventPlugin : ProcessEnginePlugin {

    override fun preInit(processEngineConfiguration: ProcessEngineConfigurationImpl) {
        with(processEngineConfiguration) {
            if (customPreBPMNParseListeners == null) {
                customPreBPMNParseListeners = mutableListOf()
            }

            if (historyEventProducer == null) {
                historyEventProducer = CacheAwareHistoryEventProducer()
            }

            customPreBPMNParseListeners.add(
                CustomHistoryParseListener(historyEventProducer)
            )
        }

        // TODO disable creating HistoryParseListener in ProcessEngineConfigurationImpl#getDefaultBPMNParseListeners()
    }

    override fun postInit(processEngineConfiguration: ProcessEngineConfigurationImpl?) = Unit

    override fun postProcessEngineBuild(processEngine: ProcessEngine?) = Unit
}