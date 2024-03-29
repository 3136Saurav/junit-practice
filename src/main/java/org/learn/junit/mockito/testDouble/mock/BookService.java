package org.learn.junit.mockito.testDouble.mock;

public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book.getPrice() < 500) return;
        bookRepository.save(book);
    }
}
