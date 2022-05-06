package com.interview.visualnuts.exercise1;

public class CounterPrinterService {
    public final NumberMapper numberMapper;

    public CounterPrinterService(NumberMapper numberMapper) {
        this.numberMapper = numberMapper;
    }

    public void printIntegers() {
        for(int count = 0; count <= 100; count++) {
            System.out.println(numberMapper.toString(count));
        }
    }
}
