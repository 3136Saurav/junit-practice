package org.learn.junit.mockito.testDouble.annotations.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    BookManager bookManager;

    @Spy
    BookService bookService;

    @Test
    public void testMockitoSpy() {
        // We need to mock getBook because it is communicating to the database or could be not implemented
        // We need to call the getAppliedDiscount to calculate the discounted price

        Book book = new Book("1234", "Spy in Action", 500, LocalDate.now());
        doReturn(book).when(bookService).findBook("1234");
        int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);

        assertEquals(450, actualDiscount);
    }
}
