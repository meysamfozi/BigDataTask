package com.kafkacassandra.kotlinkafkacassandra.entities

import org.springframework.data.cassandra.mapping.PrimaryKey
import org.springframework.data.cassandra.mapping.Table


@Table("ad_event")
data class AdEvent (
        @PrimaryKey
        val requestId: String,
		val adId: String,
		val adTitle: String,
		val advertiserCost: Double,
		val appId: String,
		val appTitle: String,
		val impressionTime: Long,
		val clickTime: Long
)
