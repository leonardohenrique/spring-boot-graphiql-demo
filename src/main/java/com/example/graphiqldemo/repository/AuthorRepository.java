package com.example.graphiqldemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.graphiqldemo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
