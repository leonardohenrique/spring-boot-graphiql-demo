package com.example.graphqldemo.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqldemo.domain.Author;
import com.example.graphqldemo.domain.Book;
import com.example.graphqldemo.domain.Genre;
import com.example.graphqldemo.graphql.input.BookInput;
import com.example.graphqldemo.repository.AuthorRepository;
import com.example.graphqldemo.repository.BookRepository;
import com.example.graphqldemo.repository.GenreRepository;

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
