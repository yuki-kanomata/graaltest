package com.example.controller

import com.example.entity.Book
import com.example.repository.BookRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.transaction.Transactional

//@Transactional
@Controller("/books")
open class BookController(private val bookRepository: BookRepository) {

    @Get("/{publisher}/query{?pageable*}")
    open fun findByPublisher(publisher: String, pageable: Pageable): Page<Book> {
        return bookRepository.findByPublisher(publisher, pageable)
    }
}