package com.interview.visualnuts.exercise2;

import com.interview.visualnuts.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonReaderTest extends FileReader {
    private final JsonReader jsonReader;

    private final JSONArray expectedJsonArray;

    JsonReaderTest() throws IOException, ParseException {
        this.jsonReader = new JsonReader();
        expectedJsonArray = (JSONArray) new JSONParser().parse(readFileToString("/exercise2/test_dataset.json"));
    }

    @Test
    public void testReadJsonFileToJsonArray() throws IOException, ParseException {
        JSONArray jsonArray = jsonReader.readJsonFileToJsonArray("/exercise2/test_dataset.json");
        assertEquals(expectedJsonArray, jsonArray);
    }

    @Test
    public void testReadJsonFileToJsonArrayThrowsIOException() throws IOException, ParseException {
        assertThrows(FileNotFoundException.class, () -> jsonReader.readJsonFileToJsonArray("/exercise2/wrong_file.json"));
    }

}