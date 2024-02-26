package org.learn.junit.mockito.testDouble.annotations.exceptionHandling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExceptionHandlingTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBooks() throws SQLException {
        when(bookRepository.findAll()).thenThrow(SQLException.class);

        // Using BDD Approach
        // given(bookRepository.findAll()).willThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testAddBook() throws SQLException {
        Book book = new Book("123", "Maven in action", 550, LocalDate.now());
        doThrow(SQLException.class).when(bookRepository).save(book);
        assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book));
    }
}
