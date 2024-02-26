package org.learn.junit.mockito.testDouble.annotations.argumentMatcher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentMatcherTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testUpdatePrice() {
        Book book = new Book("1235", "Alchemist", 300, LocalDate.now());
        when(bookRepository.findById(anyString())).thenReturn(book);
        bookService.updatePrice("1235", 700);
        verify(bookRepository).save(book);
    }

    @Test
    public void testAddBooksCollectionTypeMatcher() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("1234", "Kafka in action", 800, LocalDate.now());
        books.add(book);

        bookService.addBooks(books);
        verify(bookRepository).saveAll(anyList());
    }

}
