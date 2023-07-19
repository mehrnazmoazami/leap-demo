package com.leap.demo.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.webdriver.Url;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class BookStorePage {

    private static final String BOOKSTORE_URL = "https://demoqa.com/books";

    private static final Url BOOKSTORE_URL_CONDITION = new Url(BOOKSTORE_URL);

    private final SelenideElement addToCollectionButton = $("#addNewRecordButton");

    public void shouldBeInBookStorePage() {
        webdriver().shouldHave(BOOKSTORE_URL_CONDITION);
    }

    public void bookDetail() {
        $(".books-wrapper").find(byTagAndText("a","Git Pocket Guide")).click();
    }

    public void addToCollection() {
        addToCollectionButton.click();
    }


}
