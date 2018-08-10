package com.jdivirgilio.spring5webapp.respositories;

import com.jdivirgilio.spring5webapp.model.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { // The Long is the ID..it would be whatever the Identifier is
    
}