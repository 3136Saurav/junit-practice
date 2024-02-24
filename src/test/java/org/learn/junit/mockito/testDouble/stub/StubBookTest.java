package org.learn.junit.mockito.testDouble.stub;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
