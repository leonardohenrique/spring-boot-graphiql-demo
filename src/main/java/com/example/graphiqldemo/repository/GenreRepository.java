package com.example.graphiqldemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.graphiqldemo.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	public List<Genre> findAllDistinctByBooks_AuthorId(Long authorId);

}
