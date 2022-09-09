package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Kulikov");
        $("#userEmail").setValue("Tedos1988@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9160886262");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--012").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/лицо.jpg"));
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Igor Kulikov"),
                text("Tedos1988@mail.ru"),
                text("Male"),
                text("9160886262"),
                text("12 June,1988"),
                text("Physics"),
                text("Sports"),
                text("лицо.jpg"),
                text("Moscow"),
                text("Haryana Karnal"));


    }
}