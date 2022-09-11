package com.demoqa.test;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.test.TestData.*;

public class RegistrationFormWithTestDataTests extends TestBase{

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void fillPracticeForm() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenter(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city);

        registrationFormPage.clickSubmit();

        registrationFormPage.checkResultTable()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", expectedDateOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateAndCity);
    }

    @Test
    void fillPracticeWithMinimumDataForm() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenter(gender)
                .setNumber(number);

        registrationFormPage.clickSubmit();

        registrationFormPage.checkResultTable()
                .checkResult("Student Name", fullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number);
    }
}