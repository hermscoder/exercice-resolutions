package com.interview.visualnuts.exercise1.integration;

import com.interview.visualnuts.exercise1.CounterPrinterService;
import com.interview.visualnuts.exercise1.NumberMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterPrinterServiceIntegrationTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private final CounterPrinterService counterPrinterService;
    private final String expectedPrintedContent;
    CounterPrinterServiceIntegrationTest() throws IOException {
        this.counterPrinterService = new CounterPrinterService(new NumberMapper());
        this.expectedPrintedContent = IOUtils.toString(getClass().getResourceAsStream("/exercise1/integration/integration_output.txt"), Charset.defaultCharset());
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testPrintIntegers() {
        counterPrinterService.printIntegers();
        assertEquals(expectedPrintedContent, outputStream.toString());
    }

}