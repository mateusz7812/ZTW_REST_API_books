package com.example.books.services;
import com.example.books.models.Author;
import com.example.books.models.Book;
import com.example.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class BooksService implements IBooksService {
    @Autowired
    private BookRepository booksRepo;

    @Override
    public Collection<Book> getBooks() {
        return booksRepo.findAll();
    }

    @Override
    public Book getBook(int id) {
        return booksRepo.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return booksRepo.save(book);
    }

    @Override
    public boolean deleteBook(int id) {
        booksRepo.deleteById(id);
        return true;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book existing = booksRepo.getById(id);
        existing.merge(book);
        return booksRepo.save(existing);
    }
}