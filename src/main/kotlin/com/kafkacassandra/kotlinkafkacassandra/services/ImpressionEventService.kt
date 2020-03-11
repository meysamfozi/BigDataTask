package com.kafkacassandra.kotlinkafkacassandra.services

import org.springframework.cloud.stream.annotation.StreamListener


interface ImpressionEventService{

    @StreamListener(value = "input")
    fun receiveImpressionEvent(impression_event: ByteArray)
}
