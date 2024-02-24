package org.learn.junit.mockito.testDouble.spy;

import org.junit.jupiter.api.Test;
import org.learn.junit.mockito.testDouble.spy.Book;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SpyBookTest {

    @Test
    public void testBookSpy() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book b1 = new Book("1", "Core Java", 225, LocalDate.now());
        Book b2 = new Book("2", "Python for beginners", 200, LocalDate.now());

        bookService.addBook(b1);
        bookService.addBook(b2);

        assertEquals(2, bookRepositorySpy.timesCalled());
        assertTrue(bookRepositorySpy.calledWith(b2));
    }

    @Test
    public void testBookSpyWithMockito() {
        BookRepository bookRepositorySpy = spy(BookRepository.class);
        BookService bookService = new BookService(bookRepositorySpy);

        Book b1 = new Book("1", "Core Java", 225, LocalDate.now());
        Book b2 = new Book("2", "Python for beginners", 200, LocalDate.now());

        bookService.addBook(b1);
        bookService.addBook(b2);

        Mockito.verify(bookRepositorySpy, times(1)).save(b1);
        Mockito.verify(bookRepositorySpy, times(1)).save(b2);

    }
}
