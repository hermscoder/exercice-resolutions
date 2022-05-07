package com.interview.visualnuts.exercise2.model;

import java.util.Objects;

public class CountryLanguages {
    private String code;
    private int count;

    public String getCode() {
        return code;
    }

    public int getCount() {
        return count;
    }

    public CountryLanguages(String code, int count) {
        this.code = code;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguages that = (CountryLanguages) o;
        return count == that.count && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, count);
    }
}
