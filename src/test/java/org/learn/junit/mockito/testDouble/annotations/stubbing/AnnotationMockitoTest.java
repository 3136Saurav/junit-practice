package org.learn.junit.mockito.testDouble.annotations.stubbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnnotationMockitoTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testCalculateTotalPriceOfBooks() {
        List<String> bookIds = new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");

        Book book1 = new Book("1234", "Java in Action", 600, LocalDate.now());
        Book book2 = new Book("1235", "SQL for Dummies", 700, LocalDate.now());

//        when(bookRepository.findById("1234")).thenReturn(book1);
//        when(bookRepository.findById("1235")).thenReturn(book2);

        doReturn(book1).when(bookRepository).findById("1234");
        doReturn(book2).when(bookRepository).findById("1235");

        int actualTotalCostOfBooks = bookService.getTotalCostOfBooks(bookIds);
        int expectedTotalCostOfBooks = 1300;

        assertEquals(expectedTotalCostOfBooks, actualTotalCostOfBooks);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("1234", "Gulliver's Travels", 660, LocalDate.now());

        doNothing().when(bookRepository).save(book);
        bookService.addBook(book);
    }
}
