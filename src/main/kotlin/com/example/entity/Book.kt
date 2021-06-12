package com.example.entity

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_generator")
    @SequenceGenerator(name = "book_id_generator", initialValue = 1, allocationSize = 1)
    var id: Long? = null,

    var name: String,

    var publisher: String? = null,

    @DateCreated
    var createAt: LocalDateTime? = null,

    @DateUpdated
    var updateAt: LocalDateTime? = null,

    @Version
    var version: Int? = null
)