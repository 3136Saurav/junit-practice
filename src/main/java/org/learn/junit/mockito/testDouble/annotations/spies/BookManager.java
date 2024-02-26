package org.learn.junit.mockito.testDouble.annotations.spies;

public class BookManager {
    BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int discountRate) {
        Book book = bookService.findBook(bookId);
        int appliedDiscount = bookService.getAppliedDiscount(book, discountRate);
        return appliedDiscount;
    }
}
