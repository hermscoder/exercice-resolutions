package com.interview.visualnuts.exercise2;

import com.interview.visualnuts.exercise2.model.Country;

import java.util.Comparator;

public class MultiLanguageGermanSpeakersComparator implements Comparator<Country> {
    private static final String GERMAN_LANGUAGE_CODE = "de";
    @Override
    public int compare(Country a, Country b) {
        int aMatchPoints = 0;
        int bMatchPoints = 0;

        boolean aHasDE = contains(a.getLanguages(), GERMAN_LANGUAGE_CODE);
        boolean bHasDE = contains(b.getLanguages(), GERMAN_LANGUAGE_CODE);
        if (aHasDE && bHasDE) {
            aMatchPoints += 1;
            bMatchPoints += 1;

            if (a.getLanguages().length > b.getLanguages().length)
                aMatchPoints += 1;
            else if (b.getLanguages().length > a.getLanguages().length)
                bMatchPoints += 1;

        } else if (aHasDE) {
            aMatchPoints += 1;
        } else if (bHasDE) {
            bMatchPoints += 1;
        }

        return (aMatchPoints - bMatchPoints);
    }

    private boolean contains(String[] strArray, String value) {
        for (String str : strArray) {
            if(value.equals(str))
                return true;
        }

        return false;
    }
}
