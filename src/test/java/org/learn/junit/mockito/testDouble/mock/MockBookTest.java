package org.learn.junit.mockito.testDouble.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockBookTest {

    @Test
    public void testBookMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book b1 = new Book("1", "Core Java", 400, LocalDate.now());
        Book b2 = new Book("2", "Python for beginners", 700, LocalDate.now());

        bookService.addBook(b1);
        bookService.addBook(b2);

        bookRepositoryMock.verify(b2, 1);
    }
}
