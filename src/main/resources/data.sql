INSERT INTO Genre (id, name) VALUES
(1, 'Fantasy'),
(2, 'Classics'),
(3, 'Horror');

INSERT INTO author (id, name) VALUES 
(1, 'J.R.R. Tolkien'),
(2, 'Bram Stoker');

INSERT INTO book (id, title, author_id) VALUES 
(1, 'The Hobbit', 1),
(2, 'The Lord of the Rings', 1),
(3, 'Dracula', 2);

INSERT INTO book_genres (books_id, genres_id) VALUES 
(1 , 1), (1 , 2),
(2 , 1), (2 , 2),
(3 , 3), (3 , 2);
