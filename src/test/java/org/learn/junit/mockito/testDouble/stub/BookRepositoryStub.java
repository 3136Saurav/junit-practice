package org.learn.junit.mockito.testDouble.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();

        Book b1 = new Book("1", "Kafka in Town", 500, LocalDate.now());
        Book b2 = new Book("2", "HeadFirst Java",  800, LocalDate.now());

        newBooks.add(b1);
        newBooks.add(b2);

        return newBooks;
    }
}
