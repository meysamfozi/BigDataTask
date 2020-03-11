package com.kafkacassandra.kotlinkafkacassandra.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kafkacassandra.kotlinkafkacassandra.entities.ImpressionEvent
import com.kafkacassandra.kotlinkafkacassandra.repositories.ImpressionEventRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service


@Service
open class ImpressionEventServiceImpl: ImpressionEventService {

    @Autowired
    lateinit var impressionEventRepository: ImpressionEventRepository
    val JSON = jacksonObjectMapper()

    private val logger = LoggerFactory.getLogger(ImpressionEventService::class.java)

    @StreamListener("input")
    override fun receiveImpressionEvent(impressionEvent:ByteArray){

        val parsedMessage = JSON.readValue(impressionEvent, String::class.java)
        val impressionEvent = JSON.readValue(parsedMessage, ImpressionEvent::class.java)
        logger.info("ImpressionEvent received: " + impressionEvent)


		impressionEventRepository.save(impressionEvent)
        logger.info("ImpressionEvent added: " + impressionEvent)
    }
}
