package com.qaportfolio.utils;

import net.datafaker.Faker;

public class TestDataFactory {

    private static final Faker faker = new Faker();

    private TestDataFactory() {
        // Prevent instantiation of utility class
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateAddress() {
        return faker.address().streetAddress();
    }

    public static String generateCity() {
        return faker.address().city();
    }

    public static String generateState() {
        return faker.address().stateAbbr();
    }

    public static String generateZipCode() {
        return faker.address().zipCode();
    }

    public static String generatePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateSSN() {
        return faker.number().digits(9);
    }

    public static String generateUsername() {
        return faker.name().firstName().toLowerCase() + faker.number().digits(5);
    }

    public static String generatePassword() {
        return "Test" + faker.number().digits(4) + "!";
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
}