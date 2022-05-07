package com.interview.visualnuts.exercise2.model;

import java.util.Arrays;
import java.util.Objects;

public class Country {
    private String code;
    private String[] languages;

    public String getCode() {
        return code;
    }

    public String[] getLanguages() {
        return languages;
    }

    public Country(String code, String[] languages) {
        this.code = code;
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code) && Arrays.equals(languages, country.languages);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(code);
        result = 31 * result + Arrays.hashCode(languages);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}
