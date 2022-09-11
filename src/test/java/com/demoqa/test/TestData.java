package com.demoqa.test;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.demoqa.utils.RandomUtils.getRandomPhone;
import static com.demoqa.utils.RandomUtils.getRandomString;
import static java.lang.String.format;
import static java.util.Calendar.*;
import static java.util.Calendar.MONTH;
import static java.util.Locale.*;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class TestData {
    public static Faker faker = new Faker(new Locale("ru"));
    public static List<String> genders = List.of("Male", "Female", "Other");
    public static List<String> years = List.of("1988", "1995", "2000");
    public static List<String> months = Stream.of(getInstance().getDisplayNames(MONTH, LONG, ENGLISH).keySet().toArray())
            .map(e -> ((String) e)).collect(Collectors.toList());
    public static List<String> subjects = List.of("", "Accounting", "English");
    public static List<String> hobbies = List.of("Sports", "Reading", "Music");
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = format("%s %s", firstName, lastName),
            email = getRandomString(6) + "@ya.qa",
            gender = genders.get(nextInt(0, genders.size())),
            number = getRandomPhone(),
            day = faker.number().numberBetween(10, 30) + "",
            month = months.get(nextInt(0, 12)),
            year = years.get(nextInt(0, years.size())),
            expectedDateOfBirth = format("%s %s,%s", day, month, year),
            subject = subjects.get(nextInt(0, subjects.size())),
            currentAddress = faker.address().fullAddress(),
            hobby = hobbies.get(nextInt(0, hobbies.size())),
            picture = "лицо.jpg",
            state = "Haryana",
            city = "Karnal",
            stateAndCity = format("%s %s", state, city);

}