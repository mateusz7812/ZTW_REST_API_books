package com.example.books.controllers;
import com.example.books.models.Author;
import com.example.books.models.Book;
import com.example.books.services.IAuthorsService;
import com.example.books.services.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class BooksController {
    @Autowired
    IBooksService booksService;

    @Autowired
    IAuthorsService authorsService;

    @PostConstruct
    public void init(){
        booksService.saveBook(new Book("Potop", authorsService.saveAuthor(new Author("Henryk", "Sienkiewicz")).getId(), 936));
        booksService.saveBook(new Book("Wesele", authorsService.saveAuthor(new Author("Stanisław", "Reymont")).getId(), 150));
        booksService.saveBook(new Book("Dziady", authorsService.saveAuthor(new Author("Adam", "Mickiewicz")).getId(), 292));
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Object> postBook(@RequestBody Book book){
        return new ResponseEntity<>(booksService.saveBook(book), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable("id") int id){
        return new ResponseEntity<>(booksService.getBook(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBook(@PathVariable("id") int id, @RequestBody Book book){
        return new ResponseEntity<>(booksService.updateBook(id, book), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id){
        return new ResponseEntity<>(booksService.deleteBook(id), HttpStatus.NO_CONTENT);
    }
}

