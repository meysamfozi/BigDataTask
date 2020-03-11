package com.kafkacassandra.kotlinkafkacassandra.services

import org.springframework.cloud.stream.annotation.StreamListener


interface ClickEventService{

    @StreamListener(value = "input")
    fun receiveClickEvent(click_event: ByteArray)
}
