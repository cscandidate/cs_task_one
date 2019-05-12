package com.test.reader.json;

public interface JsonReader {

    <T> T fromJson(String json, Class<T> classOfT);
}
