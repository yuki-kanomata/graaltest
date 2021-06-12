package com.example

import com.example.entity.Book
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/books")
interface BookClient {
    @Get("/{publisher}/query{?pageable*}")
    fun findByPublisher(publisher: String, pageable: Pageable): Page<Book>
}