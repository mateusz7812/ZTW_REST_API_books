package com.example.books.services;

import com.example.books.models.Book;

import java.util.Collection;

public interface IBooksService {
    Collection<Book> getBooks();
    Book getBook(int id);

    Book saveBook(Book book);

    boolean deleteBook(int id);

    Book updateBook(int id, Book book);
}
