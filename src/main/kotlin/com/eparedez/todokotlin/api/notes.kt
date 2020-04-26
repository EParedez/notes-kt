package com.eparedez.todokotlin.api

import com.eparedez.todokotlin.models.Note
import com.eparedez.todokotlin.repositories.NoteRepository
import org.springframework.data.cassandra.core.mapping.BasicMapId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/notes")
class NotesController(private val repository: NoteRepository){

    @GetMapping()
    fun findAll() = repository.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Int) =
            repository.findById(BasicMapId.id("id",id)) ?: //TODO
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This notes does not exists")

}