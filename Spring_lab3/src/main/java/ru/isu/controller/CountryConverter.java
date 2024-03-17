package ru.isu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.isu.model.Country;
import ru.isu.repository.CountryRepository;

public class CountryConverter implements Converter<String, Country> {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country convert(String code) {
        return countryRepository.findByCode(code);
    }
}
