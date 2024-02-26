package org.learn.junit.mockito.testDouble.annotations.exceptionHandling;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() throws DatabaseReadException {
        List<Book> bookList;
        try {
            bookList = bookRepository.findAll();
        } catch (SQLException e) {
            throw new DatabaseReadException("Unable to read data from database due to - " + e.getMessage());
        }

        int totalPrice = 0;
        for (Book book : bookList) {
            totalPrice += book.getPrice();
        }

        return totalPrice;
    }

    public void addBook(Book book) throws DatabaseWriteException {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            throw new DatabaseWriteException("Unable to write data from database due to - " + e.getMessage());
        }
    }
}
