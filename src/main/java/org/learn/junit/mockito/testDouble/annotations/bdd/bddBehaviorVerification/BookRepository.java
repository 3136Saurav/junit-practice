package org.learn.junit.mockito.testDouble.annotations.bdd.bddBehaviorVerification;

public interface BookRepository {

    void save(Book book);

    Book findById(String bookId);
}
