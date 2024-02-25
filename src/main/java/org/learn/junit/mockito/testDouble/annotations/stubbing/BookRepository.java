package org.learn.junit.mockito.testDouble.annotations.stubbing;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days);

    Book findById(String bookId);

    void save(Book book);
}
