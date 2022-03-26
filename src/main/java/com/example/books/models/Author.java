package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "author")
    private List<Book> books;

    public Author(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Author() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void merge(Author other) {
        setFirst_name(other.getFirst_name());
        setLast_name(other.getLast_name());
    }

}
