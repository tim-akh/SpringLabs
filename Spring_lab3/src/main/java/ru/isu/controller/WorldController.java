package ru.isu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isu.exception.InvalidCountryCodeReference;
import ru.isu.model.Country;
import ru.isu.repository.CountryRepository;

@RequestMapping("/world")
@Controller
public class WorldController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/continent")
    public String chooseContinent(Model model) {
        model.addAttribute("continents", countryRepository.getContinents());
        return "continent";
    }

    @GetMapping(value = "/countries", params = "continent")
    public String chooseCountry(@RequestParam("continent") String continent, Model model) {
        model.addAttribute("countries", countryRepository.findByContinent(continent));
        return "countries";
    }

    @GetMapping(value = "/country", params = "code")
    public String showCountry(@RequestParam("code") Country country, Model model) throws InvalidCountryCodeReference {
        if (country == null) {
            throw new InvalidCountryCodeReference("Error: Invalid country code reference");
        }
        else {
            model.addAttribute("country", country);
        }
        return "country";
    }

}
