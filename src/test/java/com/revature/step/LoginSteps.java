package com.revature.step;

import com.revature.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("The user navigates to the landing page")
    public void the_user_navigates_to_the_landing_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("The user enters username {string}")
    public void the_user_enters_username(String username) {
        TestRunner.loginPage.sendUsername(username);
    }

    @When("The user enters password {string}")
    public void the_user_enters_a_password(String password) {
        TestRunner.loginPage.sendPassword(password);
    }

    @When("The user enters invalid username {string}")
    public void the_user_enters_invalid_username(String invalidUsername) {
        TestRunner.loginPage.sendUsername(invalidUsername);
    }

    @When("The user enters invalid password {string}")
    public void the_user_enters_invalid_password(String invalidPassword) {
        TestRunner.loginPage.sendPassword(invalidPassword);
    }
    
    @When("The user enters empty username {string}")
    public void the_user_enters_empty_username(String emptyUsername) {
        TestRunner.loginPage.sendUsername(emptyUsername);
    }
 
    @When("The user enters empty password {string}")
    public void the_user_enters_empty_password(String emptyPassword) {
        TestRunner.loginPage.sendPassword(emptyPassword);
    }

    @When("The user clicks the login button")
    public void the_user_clicks_the_login_button() {
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("The user should be logged in successfully and redirected to homepage")
    public void the_user_should_be_logged_in_successfully_and_redirected_to_homepage() {
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @Then("The user should be informed the login failed")
    public void the_user_should_be_informed_the_login_failed(){
        Alert alert = TestRunner.driver.switchTo().alert(); 
        Assert.assertEquals("login attempt failed: please try again", alert.getText());
        alert.accept();
    }

    
    
}