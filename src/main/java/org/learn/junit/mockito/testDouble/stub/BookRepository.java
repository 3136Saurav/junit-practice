package org.learn.junit.mockito.testDouble.stub;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days);
}
