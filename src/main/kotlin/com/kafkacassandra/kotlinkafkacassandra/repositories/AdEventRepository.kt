package com.kafkacassandra.kotlinkafkacassandra.repositories


import com.kafkacassandra.kotlinkafkacassandra.entities.AdEvent
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository


@Repository
interface AdEventRepository: CassandraRepository<AdEvent> {
    fun findByrequestId(requestId: String): MutableList<AdEvent>

}
