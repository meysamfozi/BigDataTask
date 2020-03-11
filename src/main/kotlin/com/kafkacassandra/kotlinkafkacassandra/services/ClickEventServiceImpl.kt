package com.kafkacassandra.kotlinkafkacassandra.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kafkacassandra.kotlinkafkacassandra.entities.ClickEvent
import com.kafkacassandra.kotlinkafkacassandra.repositories.ClickEventRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service


@Service
open class ClickEventServiceImpl: ClickEventService {

    @Autowired
    lateinit var clickEventRepository: ClickEventRepository
    val JSON = jacksonObjectMapper()

    private val logger = LoggerFactory.getLogger(ClickEventService::class.java)

    @StreamListener("input")
    override fun receiveClickEvent(clickEvent:ByteArray){

        val parsedMessage = JSON.readValue(clickEvent, String::class.java)
        val clickEvent = JSON.readValue(parsedMessage, ClickEvent::class.java)
        logger.info("ClickEvent received: " + clickEvent)


        clickEventRepository.save(clickEvent)
        logger.info("ClickEvent added: " + clickEvent)
    }
}
