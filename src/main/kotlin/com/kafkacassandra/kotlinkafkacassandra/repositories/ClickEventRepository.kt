package com.kafkacassandra.kotlinkafkacassandra.repositories


import com.kafkacassandra.kotlinkafkacassandra.entities.ClickEvent
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository


@Repository
interface ClickEventRepository: CassandraRepository<ClickEvent> {
    fun findByrequestId(requestId: String): MutableList<ClickEvent>

}
