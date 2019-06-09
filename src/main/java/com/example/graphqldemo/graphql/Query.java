package com.example.graphqldemo.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.domain.Author;
import com.example.graphqldemo.domain.Book;
import com.example.graphqldemo.repository.AuthorRepository;
import com.example.graphqldemo.repository.BookRepository;

@Component
public class Query implements GraphQLQueryResolver {

	private AuthorRepository authorRepository;

	private BookRepository bookRepository;

	@Autowired
	public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public List<Author> getAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	public List<Book> getBooksByGenreId(Long genreId) {
		return bookRepository.findAllByGenresId(genreId);
	}

}
