package org.learn.junit.mockito.testDouble.spy;

import java.util.List;

public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
