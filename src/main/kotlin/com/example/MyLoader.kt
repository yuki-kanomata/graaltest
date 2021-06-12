package com.example

import com.example.entity.*
import com.example.repository.*
import io.micronaut.context.event.ShutdownEvent
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import javax.inject.Singleton
import io.micronaut.transaction.SynchronousTransactionManager
import io.micronaut.transaction.TransactionCallback
import io.micronaut.transaction.TransactionStatus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.sql.Connection
import java.time.LocalDate
import java.util.*
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Singleton
open class MyLoader(
    private val bookRepository: BookRepository) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

//    @Transactional
    @EventListener
    open fun onStartupEvent(event: StartupEvent?) {
        logger.info("MyLoader.onStartupEvent")

        //Book
        for (i in 1..30) {
            var book: Book = Book(name = "Book X$i", publisher = "pubX")
            bookRepository.save(book)
        }
        for (i in 1..30) {
            var book: Book = Book(name = "Book Y$i", publisher = "pubY")
            bookRepository.save(book)
        }
    }

//    https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#transactions
//    @EventListener
//    fun onStartupEvent(event: StartupEvent?) {
//        println("Hello MyLoader.onStartupEvent")
//        transactionManager.executeWrite {
//            entityManager.createNativeQuery("INSERT INTO customer(id, name, description) VALUES (nextval('hibernate_sequence'), 'bob', NULL)")
//                .executeUpdate()
//            entityManager.createNativeQuery("INSERT INTO customer(id, name, description) VALUES (nextval('hibernate_sequence'), 'nancy', NULL)")
//                .executeUpdate()
//        }
//    }

    @EventListener
    open fun onShutdownEvent(event: ShutdownEvent?) {
        logger.info("MyLoader.onShutdownEvent")
        //orderRepository.deleteAll()
        //customerRepository.deleteAll()
        //productRepository.deleteAll()
    }
}
