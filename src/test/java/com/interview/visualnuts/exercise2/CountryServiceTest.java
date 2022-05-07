package com.interview.visualnuts.exercise2;

import com.interview.visualnuts.exercise2.model.Country;
import com.interview.visualnuts.exercise2.model.CountryLanguages;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class CountryServiceTest {
    private final CountryService countryService;

    private final CountryMapper countryMapper;
    private final JsonReader jsonReader;

    private final Set expectedCountrySet = new HashSet<>(
            Arrays.asList(
                    new Country("US", new String[] {"en"}),
                    new Country("BE", new String[] {"nl", "fr", "de"}),
                    new Country("NL", new String[] {"nl", "fy"}),
                    new Country("DE", new String[] {"de"}),
                    new Country("ES", new String[] {"es"})
            ));

    CountryServiceTest() throws IOException, ParseException {
        this.countryMapper = Mockito.mock(CountryMapper.class);
        this.jsonReader = Mockito.mock(JsonReader.class);

        when(countryMapper.toModel(any(JSONArray.class))).thenReturn(expectedCountrySet);
        when(jsonReader.readJsonFileToJsonArray(anyString())).thenReturn(new JSONArray());

        this.countryService = new CountryService(countryMapper, jsonReader);
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