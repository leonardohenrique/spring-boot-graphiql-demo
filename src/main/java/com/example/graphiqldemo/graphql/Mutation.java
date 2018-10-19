package com.example.graphiqldemo.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphiqldemo.domain.Author;
import com.example.graphiqldemo.domain.Book;
import com.example.graphiqldemo.domain.Genre;
import com.example.graphiqldemo.graphql.input.BookInput;
import com.example.graphiqldemo.repository.AuthorRepository;
import com.example.graphiqldemo.repository.BookRepository;
import com.example.graphiqldemo.repository.GenreRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

	private AuthorRepository authorRepository;

	private BookRepository bookRepository;

	private GenreRepository genreRepository;

	@Autowired
	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.genreRepository = genreRepository;
	}

	public Author addAuthor(String name) {
		Author author = new Author();
		author.setName(name);

		authorRepository.save(author);

		return author;
	}

	public Book addBook(BookInput bookInput) {
		Book book = new Book();
		book.setTitle(bookInput.getTitle());
		book.setAuthor(authorRepository.findById(bookInput.getAuthorId()).get());
		book.setGenres((List<Genre>) genreRepository.findAllById(bookInput.getGenreIds()));

		bookRepository.save(book);

		return book;
	}

}
