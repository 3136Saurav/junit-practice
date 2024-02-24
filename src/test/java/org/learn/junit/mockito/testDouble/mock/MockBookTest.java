package org.learn.junit.mockito.testDouble.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

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

    @Test
    public void testBookMockWithMockito() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);

        Book b1 = new Book("1", "Core Java", 400, LocalDate.now());
        Book b2 = new Book("2", "Python for beginners", 700, LocalDate.now());

        bookService.addBook(b1);
        bookService.addBook(b2);

        Mockito.verify(bookRepositoryMock, times(1)).save(b2);
        Mockito.verify(bookRepositoryMock, times(0)).save(b1);
    }
}
