package com.interview.visualnuts.exercise2;

import com.interview.visualnuts.exercise2.model.Country;
import com.interview.visualnuts.exercise2.model.CountryLanguages;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CountryService {

    private final Set<Country> countriesDataSet;

    private final CountryMapper countryMapper;
    private final JsonReader jsonReader;

    public CountryService(CountryMapper countryMapper, JsonReader jsonReader) throws IOException, ParseException {
        this.countryMapper = countryMapper;
        this.jsonReader = jsonReader;

        JSONArray countriesJsonArray = this.jsonReader.readJsonFileToJsonArray("/exercise2/dataset.json");
        this.countriesDataSet = this.countryMapper.toModel(countriesJsonArray);
    }

    public Integer countAllCountries() {
        return countriesDataSet.size();
    }

    public Country findCountryWithMostOfficialLanguagesHavingGerman() {
        List<Country> sorted = countriesDataSet.stream().sorted(new MultiLanguageGermanSpeakersComparator().reversed()).collect(Collectors.toList());

        return sorted.get(0);
    }

    public Set<CountryLanguages> countAllCountriesLanguages() {
        return countriesDataSet.stream()
                .map(country -> new CountryLanguages(country.getCode(), country.getLanguages().length))
                .collect(Collectors.toSet());
    }

    public Long countAllOfficialLanguages() {
        return countriesDataSet.stream()
                .flatMap(country -> Arrays.stream(country.getLanguages()))
                .distinct()
                .count();
    }

    public List<String> findMostCommonOfficialLanguages() {
        return findMostCommonOfficialLanguages(0L);
    }

    public List<String> findMostCommonOfficialLanguages(Long limit) {
        Map<String, Integer> hp = new HashMap<>();

        countriesDataSet.stream()
                .flatMap(country -> Arrays.stream(country.getLanguages()))
                .forEach(code -> {
                    hp.computeIfPresent(code, (key, value) -> value + 1);
                    hp.putIfAbsent(code, 1);
                });

        return hp.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit > 0 ? limit : hp.size())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

    }
}
