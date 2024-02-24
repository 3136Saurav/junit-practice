package org.learn.junit.mockito.testDouble.dummy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyBookTest {

    @Test
    public void testAddBook() {
        BookRepository fakeBookRepository = new FakeBookRepository();
        EmailService dummyEmailService = new DummyEmailService();
        BookService bookService = new BookService(fakeBookRepository, dummyEmailService);

        bookService.addBook(new Book("1", "Core Java", 225, LocalDate.now()));
        bookService.addBook(new Book("2", "Python for beginners", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());

    }
}
