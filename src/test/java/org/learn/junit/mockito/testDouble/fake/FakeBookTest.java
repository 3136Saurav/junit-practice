package org.learn.junit.mockito.testDouble.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakeBookTest {

    @Test
    public void testAddBookFake() {
        BookRepository fakeBookRepository = new FakeBookRepository();
        BookService bookService = new BookService(fakeBookRepository);

        bookService.addBook(new Book("1", "Core Java", 225, LocalDate.now()));
        bookService.addBook(new Book("2", "Python for beginners", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());

    }

    @Test
    public void testAddBookFakeWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Collection<Book> books = new ArrayList<>();
        books.add(new Book("1", "Core Java", 225, LocalDate.now()));
        books.add(new Book("2", "Python for beginners", 200, LocalDate.now()));

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBooks());
    }

}
