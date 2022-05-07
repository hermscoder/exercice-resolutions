package com.interview.visualnuts;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class FileReader {
    public String readFileToString(String filePath) throws IOException {
        return IOUtils.toString(getClass().getResourceAsStream(filePath), Charset.defaultCharset());
    }
}
