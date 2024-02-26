package org.learn.junit.mockito.testDouble.annotations.exceptionHandling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> findAll() throws SQLException;

    void save(Book book) throws SQLException;
}
