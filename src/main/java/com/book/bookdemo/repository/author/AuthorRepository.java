package com.book.bookdemo.repository.author;

import com.book.bookdemo.entity.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
