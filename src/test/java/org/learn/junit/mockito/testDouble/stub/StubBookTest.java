package org.learn.junit.mockito.testDouble.stub;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubBookTest {
    @Test
    public void testBookStub() {
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(50, 5);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(250, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(400, newBooksWithAppliedDiscount.get(1).getPrice());

    }

    @Test
    public void testBookStubWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooks = new ArrayList<>();

        Book b1 = new Book("1", "Kafka in Town", 500, LocalDate.now());
        Book b2 = new Book("2", "HeadFirst Java",  800, LocalDate.now());

        newBooks.add(b1);
        newBooks.add(b2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(50, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(250, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(400, newBooksWithAppliedDiscount.get(1).getPrice());

    }
}
