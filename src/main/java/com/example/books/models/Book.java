package com.example.books.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String title;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "AuthorId", insertable = false, updatable = false)
    private Author author;

    @Column(name = "AuthorId")
    private int author_id;
    int pages;


    public Book(String title, int author_id, int pages) {
        this.title = title;
        this.author_id = author_id;
        this.pages = pages;
    }

    public Book() {

    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public void merge(Book other) {
        setAuthor_id(other.getAuthor_id());
        setPages(other.getPages());
        setTitle(other.getTitle());
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}
