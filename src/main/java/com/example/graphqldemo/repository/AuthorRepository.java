package com.example.graphqldemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.graphqldemo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
