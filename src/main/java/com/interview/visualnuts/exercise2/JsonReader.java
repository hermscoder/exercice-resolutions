package com.interview.visualnuts.exercise2;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class JsonReader {
    public JSONArray readJsonFileToJsonArray(String filePath) throws IOException, ParseException {
        InputStream resourceAsStream = getClass().getResourceAsStream(filePath);
        if(resourceAsStream == null)
            throw new FileNotFoundException();

        String jsonStr = IOUtils.toString(resourceAsStream, Charset.defaultCharset());
        return (JSONArray) new JSONParser().parse(jsonStr);
    }
}
