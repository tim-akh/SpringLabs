package ru.isu.exception;

public class InvalidCountryCodeReference extends Exception {
    public InvalidCountryCodeReference(String errorMsg) {
        super(errorMsg);
    }
}
