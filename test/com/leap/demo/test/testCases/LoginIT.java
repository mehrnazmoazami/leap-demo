package com.leap.demo.test.testCases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.leap.demo.test.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class LoginIT {

  @AfterEach
  public void tearDown() {
    Selenide.closeWebDriver();
  }

  @Test
  public void loginPageShouldHaveWelcomeHeader() {
    LoginPage loginPage = LoginPage.open();
    loginPage.shouldHaveWelcomeHeader();
  }

  @Test
  public void failedloginWithNoUsernamePassword() {
    LoginPage loginPage = LoginPage.open();
    loginPage.login();
    loginPage.usernameShouldBeInvalid();
    loginPage.passwordShouldBeInvalid();
  }

  @Test
  public void failedloginWithEmptyUsernamePassword() {
    LoginPage loginPage = LoginPage.open();
    loginPage.login("","");
    loginPage.usernameShouldBeInvalid();
    loginPage.passwordShouldBeInvalid();
  }

  @Test
  public void failedloginWithWrongUsernamePassword() {
    LoginPage loginPage = LoginPage.open();
    loginPage.login("aa", "Qwerty");
    loginPage.shouldShowFailedloginAttempt();
  }

  @Test
  public void successfulLogin() {
    LoginPage loginPage = LoginPage.open();
    loginPage.loginToProfilePage("mehrnaz", "Qwerty9@")
            .shouldBeInProfilePage();
  }
}
