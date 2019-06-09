package com.example.graphqldemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.graphqldemo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAllByGenresId(Long genreId);

}
