package com.kafkacassandra.kotlinkafkacassandra.entities

import org.springframework.data.cassandra.mapping.PrimaryKey
import org.springframework.data.cassandra.mapping.Table


@Table("impression_event")
data class ImpressionEvent (
        @PrimaryKey
        val requestId: String, // a unique id for the request
        val adId: String,
		val adTitle: String,
		val advertiserCost: Double,
		val appId: String,
		val appTitle: String,
		val impressionTime: Long
)
