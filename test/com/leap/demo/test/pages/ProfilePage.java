package com.leap.demo.test.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.webdriver.Url;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class ProfilePage {

    private final SelenideElement logOutButton = $("#submit");

    private final SelenideElement bookStoreButton = $(byText("Book Store"));

    private static final String PROFILE_URL = "https://demoqa.com/profile";
    private static  final Url PROFILE_URL_CONDITION = new Url(PROFILE_URL);

    public void shouldBeInProfilePage() {
            webdriver().shouldHave(PROFILE_URL_CONDITION);
    }

    public void shouldHaveUserName() {
        $("#userName-label").shouldBe(visible);
        $("#userName-value").shouldHave(text("Mehrnaz"));
    }

    public LoginPage logOut() {
        logOutButton.click();
        return Selenide.page(LoginPage.class);
    }


    public BookStorePage goToBookStore() {
        if (bookStoreButton.is(hidden))
            $(".pr-1").click();
        bookStoreButton.scrollIntoView(true);
        bookStoreButton.shouldBe(enabled);
        bookStoreButton.shouldBe(interactable);
        bookStoreButton.shouldBe(visible);
        bookStoreButton.click();

        return Selenide.page(BookStorePage.class);
    }

}
