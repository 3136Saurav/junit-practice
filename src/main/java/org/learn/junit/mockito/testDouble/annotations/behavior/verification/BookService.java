package org.learn.junit.mockito.testDouble.annotations.behavior.verification;

public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book.getPrice() <= 500) return;
        bookRepository.save(book);
    }

    public void updatePrice(String bookId, int updatedPrice) {
        if (bookId == null) {
            return;
        }

        Book book = bookRepository.findById(bookId);
        if (book.getPrice() == updatedPrice) {
            return;
        }

        bookRepository.save(book);
    }
}
