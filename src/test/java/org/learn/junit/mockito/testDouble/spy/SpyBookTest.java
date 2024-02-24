package org.learn.junit.mockito.testDouble.spy;

import org.junit.jupiter.api.Test;
import org.learn.junit.mockito.testDouble.spy.Book;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
