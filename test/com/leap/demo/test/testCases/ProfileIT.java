package com.leap.demo.test.testCases;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.leap.demo.test.pages.LoginPage;
import com.leap.demo.test.pages.ProfilePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class ProfileIT {

    private ProfilePage profilePage;

    @BeforeEach
    public void setUp() {
        LoginPage loginPage = LoginPage.open();
        profilePage =  loginPage.loginToProfilePage("mehrnaz", "Qwerty9@");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void profilePageShouldHaveUserName() {
        profilePage.shouldBeInProfilePage();
        profilePage.shouldHaveUserName();
    }

    @Test
    public void successfulLogOut() {
        profilePage.shouldBeInProfilePage();
        profilePage.logOut().shouldBeInLoginPage();
    }

}
