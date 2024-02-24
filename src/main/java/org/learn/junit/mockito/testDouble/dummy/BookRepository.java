package org.learn.junit.mockito.testDouble.dummy;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);
    Collection<Book> findAll();
}
