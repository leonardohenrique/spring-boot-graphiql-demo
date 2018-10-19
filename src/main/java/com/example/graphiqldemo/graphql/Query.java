package com.example.graphiqldemo.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphiqldemo.domain.Author;
import com.example.graphiqldemo.domain.Book;
import com.example.graphiqldemo.repository.AuthorRepository;
import com.example.graphiqldemo.repository.BookRepository;

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
