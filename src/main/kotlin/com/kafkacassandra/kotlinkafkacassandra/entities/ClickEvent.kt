package com.kafkacassandra.kotlinkafkacassandra.entities

import org.springframework.data.cassandra.mapping.PrimaryKey
import org.springframework.data.cassandra.mapping.Table


@Table("click_event")
data class ClickEvent (
        @PrimaryKey
        val requestId: String,
		val clickTime: Long
)
