package org.learn.junit.mockito.testDouble.annotations.behavior.verification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnnotationBehaviorTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testAddBook() {
        Book book = new Book("1234", "Invisible Man", 550, LocalDate.now());

        bookService.addBook(book);
        verify(bookRepository).save(book);
    }

    @Test
    public void testAddBookWithPriceLessThan500() {
        Book book = new Book("1235", "Alchemist", 300, LocalDate.now());

        bookService.addBook(book);
        verify(bookRepository, times(0)).save(book);
    }

    @Test
    public void testUpdatePriceWithNullBookId() {
        bookService.updatePrice(null, 500);
        verifyNoInteractions(bookRepository);
    }

    @Test
    public void testUpdatePriceWithEqualPrice() {
        Book book = new Book("1235", "Alchemist", 300, LocalDate.now());
        when(bookRepository.findById("1235")).thenReturn(book);
        bookService.updatePrice("1235", 300);
        verify(bookRepository).findById("1235");
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void testUpdatePriceInProperOrder() {
        Book book = new Book("1235", "Alchemist", 300, LocalDate.now());
        when(bookRepository.findById("1235")).thenReturn(book);
        bookService.updatePrice("1235", 700);

        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findById("1235");
        inOrder.verify(bookRepository).save(book);
    }
}
