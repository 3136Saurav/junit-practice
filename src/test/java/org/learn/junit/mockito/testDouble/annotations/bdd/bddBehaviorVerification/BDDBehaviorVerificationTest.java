package org.learn.junit.mockito.testDouble.annotations.bdd.bddBehaviorVerification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
public class BDDBehaviorVerificationTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void test_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated() {
        // Given - Arrange
        Book book = new Book("1235", "Alchemist", 300, LocalDate.now());
        given(bookRepository.findById("1235")).willReturn(book);

        // When - Act
        bookService.updatePrice("1235", 750);

        // Then - Assert/Verify
        then(bookRepository).should().save(book);

    }
}
