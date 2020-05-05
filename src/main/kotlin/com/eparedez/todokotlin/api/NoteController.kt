package com.eparedez.todokotlin.api

import com.eparedez.todokotlin.models.entity.Note
import com.eparedez.todokotlin.models.repositories.INoteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/notes")
class NotesController(private val noteRepository: INoteRepository){

    @GetMapping()
    fun findAll(): List<Note> = noteRepository.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: UUID) : ResponseEntity<Note> {
        return noteRepository.findById(id).map { note -> ResponseEntity.ok(note) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping(produces = [APPLICATION_JSON_VALUE])
    fun create(@Valid @RequestBody note: Note) =
        noteRepository.save(note) ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request")


}