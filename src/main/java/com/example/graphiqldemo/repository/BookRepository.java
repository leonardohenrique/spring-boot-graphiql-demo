package com.example.graphiqldemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.graphiqldemo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAllByGenresId(Long genreId);

}
