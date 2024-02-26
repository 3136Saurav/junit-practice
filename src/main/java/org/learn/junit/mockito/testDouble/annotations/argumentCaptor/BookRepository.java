package org.learn.junit.mockito.testDouble.annotations.argumentCaptor;

public interface BookRepository {

    void save(Book book);

    Book findById(String bookId);
}
