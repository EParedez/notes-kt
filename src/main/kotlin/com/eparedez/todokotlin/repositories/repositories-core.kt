package com.eparedez.todokotlin.repositories

import com.eparedez.todokotlin.models.Note
import org.springframework.data.cassandra.core.mapping.MapId
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : CassandraRepository<Note, MapId> {

}