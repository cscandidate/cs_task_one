package com.test.reader.json;

import com.google.gson.Gson;

public class GsonJsonReader implements JsonReader {

    private Gson gson = new Gson();

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
