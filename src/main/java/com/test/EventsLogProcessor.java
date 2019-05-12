package com.test;

import com.test.reader.EventsLogReader;

import java.io.File;

public class EventsLogProcessor {

    public static void main(String[] args) {

        if(args[0] == null){
            throw new IllegalArgumentException("File path has not been defined. Please do that as firs argument of invocation");
        }

        new EventsLogReader().read(new File(args[0]));
    }
}
