package com.book.bookdemo.service;

import com.book.bookdemo.entity.author.Author;
import com.book.bookdemo.entity.book.Book;
import com.book.bookdemo.repository.author.AuthorRepository;
import com.book.bookdemo.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


}
