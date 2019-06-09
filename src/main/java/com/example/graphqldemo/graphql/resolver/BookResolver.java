package com.example.graphqldemo.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqldemo.domain.Author;
import com.example.graphqldemo.domain.Book;
import com.example.graphqldemo.repository.AuthorRepository;

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