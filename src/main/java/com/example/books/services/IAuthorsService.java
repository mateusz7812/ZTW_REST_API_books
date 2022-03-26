package com.example.books.services;


import com.example.books.models.Author;

import java.util.Collection;

public interface IAuthorsService {
    Collection<Author> getAuthors();

    Author saveAuthor(Author author);

    Author getAuthor(int id);

    Author updateAuthor(int id, Author author);

    boolean deleteAuthor(int id);
}
