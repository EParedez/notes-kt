package com.eparedez.todokotlin.models

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table
class Note (
   @PrimaryKey
   var id: String,
   var name: String,
   var description: String
)
