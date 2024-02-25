package org.learn.junit.mockito.testDouble.annotations.support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testBookStubWithMockitoAnnotations() {
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
