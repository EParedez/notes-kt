package com.eparedez.todokotlin.models.entity

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("notes")
class Note (
   @PrimaryKey
   var id: UUID,
   var name: String,
   var description: String,
   var plain: String,
   var html: String
)
