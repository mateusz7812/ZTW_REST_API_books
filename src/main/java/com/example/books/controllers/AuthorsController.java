package com.example.books.controllers;

import com.example.books.models.Author;
import com.example.books.models.Book;
import com.example.books.services.IAuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorsController {
    @Autowired
    IAuthorsService authorsService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthors(){
        return new ResponseEntity<>(authorsService.getAuthors(), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<Object> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorsService.saveAuthor(author), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id){
        return new ResponseEntity<>(authorsService.getAuthor(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthorBooks(@PathVariable("id") int id){
        return new ResponseEntity<>(authorsService.getAuthor(id).getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAuthor(@PathVariable("id") int id, @RequestBody Author author){
        return new ResponseEntity<>(authorsService.updateAuthor(id, author), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") int id){
        return new ResponseEntity<>(authorsService.deleteAuthor(id), HttpStatus.NO_CONTENT);
    }
}
