package org.learn.junit.mockito.testDouble.annotations.bdd.bddStubbing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BDDMockitoStub {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testCalculateTotalPriceOfBooksWithTraditionalMockito() {
        // Given

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
    @DisplayName("")
    public void test_Given_newBooks_When_GetNewBooksWithAppliedDiscountIsCalled_Then_NewBooksWithAppliedDiscountIsReturned() {
        // Arrange - Given
        Book book1 = new Book("1234", "Java in Action", 600, LocalDate.now());
        Book book2 = new Book("1235", "SQL for Dummies", 700, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        given(bookRepository.findNewBooks(7)).willReturn(newBooks);

        // Act - When
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        // Assert - Then
        assertThat(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(540);
        assertThat(newBooksWithAppliedDiscount.get(1).getPrice()).isEqualTo(630);
    }

}
