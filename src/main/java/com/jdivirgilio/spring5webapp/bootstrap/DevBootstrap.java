package com.jdivirgilio.spring5webapp.bootstrap;

import com.jdivirgilio.spring5webapp.model.Author;
import com.jdivirgilio.spring5webapp.model.Book;
import com.jdivirgilio.spring5webapp.respositories.AuthorRepository;
import com.jdivirgilio.spring5webapp.respositories.BookRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository; // These guys are going to get autowired in by injection dependency
    private BookRepository bookRepository; // These guys are going to get autowired in by injection dependency

    @Override // This will get called when 
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public DevBootstrap(AuthorRepository authorR, BookRepository bookR) {
        this.authorRepository = authorR;
        this.bookRepository = bookR;
    }

    private void initData() {

        Author guy1 = new Author("John", "DiVirgilio");
        Book book1  = new Book("Learning Javascript", "123435151", "Addison Wesley");
        guy1.getBooks().add(book1);
        book1.getAuthors().add(guy1);

        // Write it out to the db
        authorRepository.save(guy1); 
        bookRepository.save(book1);

        Author guy2 = new Author("Johnny", "McAnally");
        Book book2  = new Book("Learning Java", "2345151", "Oracle Press");
        guy2.getBooks().add(book2);
        book2.getAuthors().add(guy2);
        book2.getAuthors().add(guy1);

        // Write it out to the db
        authorRepository.save(guy2);
        bookRepository.save(book2);
    }
}