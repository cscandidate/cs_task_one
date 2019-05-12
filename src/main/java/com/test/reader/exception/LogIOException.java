package com.test.reader.exception;

import java.io.IOException;

public class LogIOException extends RuntimeException {

    public LogIOException(IOException e) {
        super(e);
    }
}
