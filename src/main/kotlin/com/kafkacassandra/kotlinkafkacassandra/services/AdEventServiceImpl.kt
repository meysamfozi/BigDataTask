package com.kafkacassandra.kotlinkafkacassandra.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kafkacassandra.kotlinkafkacassandra.entities.AdEvent
import com.kafkacassandra.kotlinkafkacassandra.repositories.AdEventRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service


@Service
open class AdEventServiceImpl: AdEventService {

    @Autowired
    lateinit var adEventRepository: AdEventRepository
    val JSON = jacksonObjectMapper()

    private val logger = LoggerFactory.getLogger(AdEventService::class.java)

    @StreamListener("input")
    override fun receiveAdEvent(adEvent:ByteArray){

        val parsedMessage = JSON.readValue(adEvent, String::class.java)
        val adEvent = JSON.readValue(parsedMessage, AdEvent::class.java)
        logger.info("AdEvent received: " + adEvent)


        adEventRepository.save(adEvent)
        logger.info("AdEvent added: " + adEvent)
    }
}
