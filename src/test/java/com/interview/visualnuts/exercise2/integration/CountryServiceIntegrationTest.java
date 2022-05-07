package com.interview.visualnuts.exercise2.integration;

import com.interview.visualnuts.exercise2.CountryMapper;
import com.interview.visualnuts.exercise2.CountryService;
import com.interview.visualnuts.exercise2.JsonReader;
import com.interview.visualnuts.exercise2.model.Country;
import com.interview.visualnuts.exercise2.model.CountryLanguages;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CountryServiceIntegrationTest {
    private final CountryService countryService;

    public CountryServiceIntegrationTest() throws IOException, ParseException {
        countryService = new CountryService(new CountryMapper(), new JsonReader());
    }

    @Test
    public void testCountAllCountries() {
        countryService.countAllCountries();
    }

    @Test
    public void testFindCountryWithMostOfficialLanguagesHavingGerman() {
        Country countryWithMostOfficialLanguagesHavingGerman = countryService.findCountryWithMostOfficialLanguagesHavingGerman();

        Country expected = new Country("BE", new String[]{"nl", "fr", "de"});

        assertNotNull(countryWithMostOfficialLanguagesHavingGerman);
        assertEquals(expected, countryWithMostOfficialLanguagesHavingGerman);

    }

    @Test
    public void testCountAllCountriesLanguages() {
        Set<CountryLanguages> countriesLanguageCount = countryService.countAllCountriesLanguages();

        Set<CountryLanguages> expectedCountryLanguagesSet = new HashSet<>(
                Arrays.asList(
                        new CountryLanguages("US", 1),
                        new CountryLanguages("BE", 3),
                        new CountryLanguages("NL", 2),
                        new CountryLanguages("DE", 1),
                        new CountryLanguages("ES", 1)
                ));
        assertNotNull(countriesLanguageCount);
        assertEquals(expectedCountryLanguagesSet, countriesLanguageCount);
    }

    @Test
    public void testCountAllOfficialLanguages() {
        Long officialLanguagesCount = countryService.countAllOfficialLanguages();

        assertNotNull(officialLanguagesCount);
        assertEquals(6, officialLanguagesCount);
    }

    @Test
    public void testFindMostCommonOfficialLanguages() {

        List<String> commonOfficialLanguagesCount = countryService.findMostCommonOfficialLanguages();
        assertEquals(Arrays.asList("de", "nl", "fy", "en", "fr", "es"), commonOfficialLanguagesCount);

        commonOfficialLanguagesCount = countryService.findMostCommonOfficialLanguages(2L);
        assertEquals(Arrays.asList("de", "nl"), commonOfficialLanguagesCount);

        commonOfficialLanguagesCount = countryService.findMostCommonOfficialLanguages(4L);
        assertEquals(Arrays.asList("de", "nl", "fy", "en"), commonOfficialLanguagesCount);
    }
}
