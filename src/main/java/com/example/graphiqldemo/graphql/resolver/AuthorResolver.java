package com.example.graphiqldemo.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphiqldemo.domain.Author;
import com.example.graphiqldemo.domain.Genre;
import com.example.graphiqldemo.repository.GenreRepository;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

	private GenreRepository genreRepository;

	@Autowired
	public AuthorResolver(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	public List<Genre> getGenres(Author author) {
		return genreRepository.findAllDistinctByBooks_AuthorId(author.getId());
	}
}
