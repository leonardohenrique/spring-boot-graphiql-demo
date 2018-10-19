package com.example.graphiqldemo.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphiqldemo.domain.Author;
import com.example.graphiqldemo.domain.Book;
import com.example.graphiqldemo.repository.AuthorRepository;

@Component
public class BookResolver implements GraphQLResolver<Book> {

	private AuthorRepository authorRepository;

	@Autowired
	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Book book) {
		return authorRepository.findById(book.getAuthor().getId()).get();
	}

}