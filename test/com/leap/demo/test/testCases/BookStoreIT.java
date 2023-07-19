package com.leap.demo.test.testCases;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.leap.demo.test.pages.BookStorePage;
import com.leap.demo.test.pages.LoginPage;
import com.leap.demo.test.pages.ProfilePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class BookStoreIT {

    private BookStorePage bookStorePage;

    @BeforeEach
    public void setUp() {
        LoginPage loginPage = LoginPage.open();
        ProfilePage profilePage =  loginPage.loginToProfilePage("mehrnaz", "Qwerty9@");
        bookStorePage = profilePage.goToBookStore();
        bookStorePage.shouldBeInBookStorePage();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void addToCollection() {
        bookStorePage.bookDetail();
        bookStorePage.addToCollection();
    }
}


