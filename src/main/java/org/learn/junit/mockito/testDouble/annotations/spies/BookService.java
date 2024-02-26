package org.learn.junit.mockito.testDouble.annotations.spies;

import org.learn.junit.mockito.testDouble.stub.BookRepository;

import java.util.List;

public class BookService {
    public Book findBook(String bookId) {
        throw new RuntimeException("Method not implemented!");
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (discountRate * price) / 100;
        return newPrice;
    }
}
