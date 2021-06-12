package com.example.repository

import com.example.entity.Book
//import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.PageableRepository
//import javax.persistence.EntityManager
//import javax.persistence.TypedQuery

//@Repository
//abstract class BookRepository(private val entityManager: EntityManager) : PageableRepository<Book, Long> {
//
//    abstract fun findByPublisher(publisher: String, pageable: Pageable): Page<Book>
//
//    @Query("FROM Book b WHERE b.publisher = :publisher ORDER BY b.id", countQuery = "SELECT COUNT(b.id) FROM Book b WHERE b.publisher = :publisher")
//    abstract fun findByPublisherByQuery(publisher: String, pageable: Pageable): Page<Book>
//
//    fun findByPublisherCustomImpl(publisher: String, pageable: Pageable): Page<Book> {
//        var query: TypedQuery<Book> = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher ORDER BY b.id", Book::class.java)
//        query.maxResults = pageable.size
//        query.firstResult = pageable.offset.toInt()
//        query.setParameter("publisher", publisher)
//
//        var resultList: List<Book> = query.resultList
//
//        var total: Long = entityManager.createQuery("SELECT COUNT(b) FROM Book b WHERE b.publisher = :publisher", Long::class.javaObjectType)
//            .setParameter("publisher", publisher)
//            .singleResult
//        return Page.of(resultList, pageable, total);
//    }
//}

@Repository
abstract class BookRepository : PageableRepository<Book, Long> {
    abstract fun findByPublisher(publisher: String, pageable: Pageable): Page<Book>
}