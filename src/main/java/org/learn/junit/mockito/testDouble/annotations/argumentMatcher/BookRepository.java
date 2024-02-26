package org.learn.junit.mockito.testDouble.annotations.argumentMatcher;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findById(String bookId);

    void saveAll(List<Book> books);
}
