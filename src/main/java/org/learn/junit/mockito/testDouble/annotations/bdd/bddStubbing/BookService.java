package org.learn.junit.mockito.testDouble.annotations.bdd.bddStubbing;

import java.util.List;

public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);

        for (Book book : newBooks) {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }

        return newBooks;
    }

    public int getTotalCostOfBooks(List<String> bookIds) {
        int totalCost = 0;

        for (String bookId : bookIds) {
            Book book = bookRepository.findById(bookId);
            totalCost += book.getPrice();
        }

        return totalCost;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
