package com.jdivirgilio.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import com.jdivirgilio.spring5webapp.model.Author;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; // ID is used by the DB. this is known as leakage. True OO world wouldn't care about an id    public String title;
    private String isbn;
    private String publisher;
    private String title;

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book( String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book( String title, String isbn, String publisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getId() { 
        return id; 
    }
    public String getTitle() { 
        return title; 
    }
    public String getIsbn()  { 
        return isbn; 
    }
    public String getPublisher() { 
        return publisher; 
    }
    public Set<Author> getAuthors() { 
        return authors; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }
    public void setIsbn(String isbn) { 
        this.isbn = isbn; 
    }
    public void setPublisher(String publisher) { 
        this.publisher = publisher; 
    }
    public void setAuthors(Set<Author> authors) { 
        this.authors = authors; 
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return id != null ? id.equals(book.id) : book.id == null;
    }

    //@Override
    public int hashcode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book {" + 
                "id=" + id +
                ", title='" + title + '\'' +
                ", isdn='" + isbn + '\'' +
                ", publisher=" + publisher + '}';
    }

}