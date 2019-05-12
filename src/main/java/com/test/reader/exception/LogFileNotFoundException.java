package com.test.reader.exception;

import java.io.FileNotFoundException;

public class LogFileNotFoundException extends RuntimeException {

    public LogFileNotFoundException(FileNotFoundException e) {
        super(e);
    }
}
