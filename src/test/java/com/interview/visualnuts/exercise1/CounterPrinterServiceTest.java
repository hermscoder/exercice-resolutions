package com.interview.visualnuts.exercise1;

import com.interview.visualnuts.exercise1.CounterPrinterService;
import com.interview.visualnuts.exercise1.NumberMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

class CounterPrinterServiceTest {

    private final CounterPrinterService counterPrinterService;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private final NumberMapper numberMapper;

    private final String expectedPrintedContent;
    CounterPrinterServiceTest() throws IOException {
        this.numberMapper = Mockito.mock(NumberMapper.class);
        this.counterPrinterService = new CounterPrinterService(numberMapper);
        this.expectedPrintedContent = IOUtils.toString(getClass().getResourceAsStream("/exercise1/output_mock.txt"), Charset.defaultCharset());
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
        Mockito.when(numberMapper.toString(anyInt())).thenReturn("Visual Nuts");
        counterPrinterService.printIntegers();

        assertEquals(expectedPrintedContent, outputStream.toString());
    }

}