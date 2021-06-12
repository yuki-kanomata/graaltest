package com.example

import com.example.entity.Book
import io.micronaut.core.type.Argument
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpRequest
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class BookControllerTest {

    @Inject
    lateinit var bookClient: BookClient

    @Inject
    @field:Client("/")
    lateinit var httpClient: RxHttpClient

//    Pageableがバインドできない
//    http://localhost:8080/books/pubX/query?offset=20&sorted=false&size=10&number=2&sort=io.micronaut.data.model.DefaultSort%4020
//    Cannot sort on non-existent property path: io.micronaut.data.model.DefaultSort
//    @Test
//    fun findByPublisher1() {
//        var response = bookClient.findByPublisher("pubX", Pageable.from(2, 10))
//        assertNotNull(response)
//    }

    @Test
    fun findByPublisher2() {
        var request = HttpRequest.GET<Any>("books/pubX/query?page=2&size=10")
        val response = httpClient.toBlocking().exchange(request, Argument.of(Page::class.java, Book::class.java))
        assertNotNull(response)
    }
}