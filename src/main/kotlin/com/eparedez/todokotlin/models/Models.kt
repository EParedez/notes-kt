package com.eparedez.todokotlin.models

import org.springframework.data.cassandra.core.cql.Ordering
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("notes")
class Note (
   //TODO
   /*@PrimaryKeyColumn(
           name="id",
           ordinal = 2,
           type = PrimaryKeyType.PARTITIONED,
           ordering = Ordering.DESCENDING
   )
   var id: UUID,*/
   @PrimaryKey
   var id: String,
   var name: String,
   var description: String
)
