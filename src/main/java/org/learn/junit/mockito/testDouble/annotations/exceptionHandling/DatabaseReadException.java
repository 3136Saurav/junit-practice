package org.learn.junit.mockito.testDouble.annotations.exceptionHandling;

public class DatabaseReadException extends Throwable {
    public DatabaseReadException(String message) {
        super(message);
    }
}
