package com.kafkacassandra.kotlinkafkacassandra.repositories


import com.kafkacassandra.kotlinkafkacassandra.entities.ImpressionEvent
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository


@Repository
interface ImpressionEventRepository: CassandraRepository<ImpressionEvent> {
    fun findByrequestId(requestId: String): MutableList<ImpressionEvent>

}
