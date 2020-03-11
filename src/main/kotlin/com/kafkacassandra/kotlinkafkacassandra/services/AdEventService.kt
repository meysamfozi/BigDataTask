package com.kafkacassandra.kotlinkafkacassandra.services

import org.springframework.cloud.stream.annotation.StreamListener


interface AdEventService{

    @StreamListener(value = "input")
    fun receiveAdEvent(ad_event: ByteArray)
}
