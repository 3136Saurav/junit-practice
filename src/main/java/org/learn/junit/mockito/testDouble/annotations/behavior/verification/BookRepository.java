package org.learn.junit.mockito.testDouble.annotations.behavior.verification;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findById(String bookId);
}
