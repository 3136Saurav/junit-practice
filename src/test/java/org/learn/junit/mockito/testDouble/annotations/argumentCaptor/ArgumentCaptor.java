package org.learn.junit.mockito.testDouble.annotations.argumentCaptor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptor {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

//    @Captor
//    ArgumentCaptor<Book> bookArgumentCaptor;

    @Test
    public void testAddBook() {
        Book book = new Book("1234", "Invisible Man", 900, LocalDate.now());
        bookService.addBook(book);

        // TODO: Implement ArgumentCaptor test cases

//        verify(bookRepository).save(bookArgumentCaptor.capture());
    }

}
