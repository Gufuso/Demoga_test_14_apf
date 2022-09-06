package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2560x1440";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Igor");
        $("#userEmail").setValue("Tedos1988@mail.ru");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("Ruazan");
        $("#submit").click();

        $("#output #name").shouldHave(text("Igor"));
        $("#output #email").shouldHave(text("Tedos1988@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Moscow"));
        $("#output #permanentAddress").shouldHave(text("Ruazan"));
    }
}