package com.book.bookdemo.repository.book;

import com.book.bookdemo.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // No additional code is required; JpaRepository provides basic CRUD operations.
}
