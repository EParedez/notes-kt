package com.eparedez.todokotlin.api

import com.eparedez.todokotlin.models.entity.Note
import com.eparedez.todokotlin.models.repositories.INoteRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/notes")
class NotesController(private val noteRepository: INoteRepository){

    @GetMapping()
    fun findAll(): List<Note> = noteRepository.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: UUID) =
            noteRepository.findById(id) ?:
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This notes does not exists")

}