package com.leap.demo.test.pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.webdriver.Url;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
  private final SelenideElement usernameField = $("#userName");
  private final SelenideElement passwordField = $("#password");
  private final SelenideElement loginButton = $("#login");
  private static final Condition INVALID_CSS_SELECTOR = cssClass("is-invalid");
  private static final String LOGIN_URL = "https://demoqa.com/login";
  private static final Url LOGIN_URL_CONDITION = new Url(LOGIN_URL);

  public static LoginPage open() {
    LoginPage page = Selenide.open(LOGIN_URL, LoginPage.class);
    page.shouldBeInLoginPage();
    return page;
  }

  public void shouldBeInLoginPage() {
    webdriver().shouldHave(LOGIN_URL_CONDITION);
  }

  public void shouldHaveWelcomeHeader() {
    $("#userForm").find(byTagAndText("h2", "Welcome,")).shouldBe(visible);
    $("#userForm").find(byTagAndText("h5", "Login in Book Store")).shouldBe(visible);
  }

  public void username(String text) {
    usernameField.shouldBe(editable)
                 .val(text);
  }

  public void usernameShouldBeInvalid() {
    usernameField.shouldHave(INVALID_CSS_SELECTOR);
  }
  public void password(String text) {
    passwordField.shouldBe(editable)
                 .val(text);
  }

  public void passwordShouldBeInvalid() {
    passwordField.shouldHave(INVALID_CSS_SELECTOR);
  }

  public void login() {
    loginButton.click();
  }

  public void login(String username, String password) {
    username(username);
    password(password);
    login();
  }

  public ProfilePage loginToProfilePage(String username, String password) {
    login(username, password);
    return Selenide.page(ProfilePage.class);
  }

  public void shouldShowFailedloginAttempt() {
    usernameField.shouldNotHave(INVALID_CSS_SELECTOR);
    passwordField.shouldNotHave(INVALID_CSS_SELECTOR);
    $("#name").shouldBe(visible)
           // .shouldHave(cssValue("color", "red"))
            .shouldHave(text("Invalid username or password"));
  }
}
