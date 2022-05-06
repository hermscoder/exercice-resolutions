package com.interview.visualnuts.exercise1;

import com.interview.visualnuts.exercise1.NumberMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberMapperTest {

    public final NumberMapper numberMapper;

    NumberMapperTest() {
        this.numberMapper = new NumberMapper();
    }

    @Test
    public void testToString() {
        assertEquals(String.valueOf(17), numberMapper.toString(17));
        assertEquals("Visual Nuts", numberMapper.toString(0));
        assertEquals("Visual", numberMapper.toString(3));
        assertEquals("Nuts", numberMapper.toString(5));
        assertEquals("Visual Nuts", numberMapper.toString(15));
        assertEquals(String.valueOf(-1), numberMapper.toString(-1));
    }
}