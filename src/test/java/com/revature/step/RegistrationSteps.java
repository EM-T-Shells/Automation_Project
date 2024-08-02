package com.revature.step;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSteps {

    @When("The user clicks Create Account link and is redirected to the registration page")
    public void the_user_clicks_Create_Account_link_and_is_redirected_to_the_registration_page() {
        TestRunner.loginPage.clickCreateAccount();
        Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
    }

    @When("The user provides a valid username {string}")
    public void the_user_provides_a_valid_username(String validUsername) {
        TestRunner.createAccountPage.sendUsername(validUsername);
    }

    @When("The user enters a username that is exactly {int} characters {string}")
    public void the_user_enters_a_username_that_is_exactly_characters(Integer int1, String username30Chars) {
        TestRunner.createAccountPage.sendUsername(username30Chars);
    }

    @When("The user provides a non-unique username {string}")
    public void the_user_provides_a_non_unique_username(String nonUniqueUsername) {
        TestRunner.createAccountPage.sendUsername(nonUniqueUsername);
    }

    @When("The user provides a too long username {string}")
    public void the_user_enters_a_too_long_username(String tooLongUsername) {
        TestRunner.createAccountPage.sendUsername(tooLongUsername);
    }

    @When("The user provides an empty username")
    public void the_user_provides_an_empty_username() {
        TestRunner.createAccountPage.sendUsername("");
    }

    @When("The user provides a valid password {string}")
    public void the_user_provides_a_valid_password(String validPassword) {
        TestRunner.createAccountPage.sendPassword(validPassword);
    }

    @When("The user provides a username that is exactly thirty characters {string}")
    public void the_user_provides_a_username_that_is_exactly_thirty_characters(String username30Chars) {
        TestRunner.createAccountPage.sendUsername(username30Chars);
    }

    @When("The user provides a too long password {string}")
    public void the_user_provides_a_too_long_password(String tooLongPassword) {
        TestRunner.createAccountPage.sendPassword(tooLongPassword);
    }

    @When("The user provides an invalid password {string}")
    public void the_user_provides_an_invalid_password(String invalidPassword) {
        TestRunner.createAccountPage.sendPassword(invalidPassword);
    }

    @When("The user provides an empty password")
    public void the_user_provides_an_empty_password() {
        TestRunner.createAccountPage.sendPassword("");
    }

    @When("The user provides a password that is exactly thirty characters {string}")
    public void the_user_provides_a_password_that_is_exactly_thirty_characters(String password30Chars) {
        TestRunner.createAccountPage.sendPassword(password30Chars);
    }

    @When("The user clicks the Create button")
    public void the_user_clicks_the_Create_button() {
        TestRunner.createAccountPage.clickCreateButton();
    }

    @When("The user is alerted that Account created successfully with username {string} and password {string}")
    public void theUserIsAlertedThatAccountCreatedSuccessfullyWithUsernameAndPassword(String username, String password) {
        TestRunner.createAccountPage.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Account created successfully with username \"" + username + "\" and password \"" + password + "\"", alert.getText());
    }

    @When("The user clicks OK to dismiss the alert")
    public void the_user_clicks_OK_to_dismiss_the_alert() {
        Alert alert = TestRunner.driver.switchTo().alert();
        alert.accept();
    }

    @Then("The user is redirected to the login page")
    public void the_user_is_redirected_to_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @Then("The user is alerted that Account creation failed with username {string} and password {string}")
    public void the_user_is_alerted_that_Account_creation_failed_with_username_and_password(String username, String password) {
        TestRunner.createAccountPage.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Account creation failed with username \"" + username + "\" and password \"" + password + "\"", alert.getText());
        alert.accept();
    }

}
