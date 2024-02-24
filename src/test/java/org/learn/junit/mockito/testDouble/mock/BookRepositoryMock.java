package org.learn.junit.mockito.testDouble.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {
    int saveCalled = 0;
    Book lastBookAdded = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastBookAdded = book;
    }

    public void verify(Book book, int timesCalled) {
        assertEquals(timesCalled, saveCalled);
        assertEquals(book, lastBookAdded);
    }

}
