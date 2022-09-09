package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
    }

    @Test
    void fillPracticeForm() {
        registrationFormPage.openPage()
                .setFirstName("Igor")
                .setLastName("Kulikov")
                .setEmail("Tedos1988@mail.ru")
                .setGenter("Male")
                .setNumber("9160886262")
                .setBirthDate("12", "June", "1988")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setPicture("лицо.jpg")
                .setCurrentAddress("Moscow")
                .setState("Haryana")
                .setCity("Karnal");

        registrationFormPage.clickSubmit();

        registrationFormPage.checkResultTable()
                .checkResult("Student Name", "Igor Kulikov")
                .checkResult("Student Email", "Tedos1988@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9160886262")
                .checkResult("Date of Birth", "12 June,1988")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "лицо.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void fillPracticeWithMinimumDataForm() {
        registrationFormPage.openPage()
                .setFirstName("Igor")
                .setLastName("Kulikov")
                .setGenter("Male")
                .setNumber("9160886262");

        registrationFormPage.clickSubmit();

        registrationFormPage.checkResultTable()
                .checkResult("Student Name", "Igor Kulikov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9160886262");
    }
}