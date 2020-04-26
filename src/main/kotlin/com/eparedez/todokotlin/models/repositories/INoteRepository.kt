package com.eparedez.todokotlin.models.repositories

import com.eparedez.todokotlin.models.entity.Note
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface INoteRepository : CassandraRepository<Note, UUID> {

}