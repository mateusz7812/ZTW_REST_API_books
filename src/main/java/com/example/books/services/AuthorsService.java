package com.example.books.services;

import com.example.books.models.Author;
import com.example.books.repositories.AuthorRepository;
import com.example.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthorsService implements IAuthorsService {

    @Autowired
    private AuthorRepository authorsRepo;

    @Override
    public Collection<Author> getAuthors() {
        return authorsRepo.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorsRepo.save(author);
    }

    @Override
    public Author getAuthor(int id) {
        return authorsRepo.getById(id);
    }

    @Override
    public Author updateAuthor(int id, Author author) {
        Author existing = authorsRepo.getById(id);
        existing.merge(author);
        return authorsRepo.save(existing);
    }

    @Override
    public boolean deleteAuthor(int id) {
        authorsRepo.deleteById(id);
        return true;
    }
}
