package com.revature.step;

import com.revature.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
    @Given("The user navigates to the landing page")
    public void the_user_navigates_to_the_landing_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("The user enters username {string}")
    public void the_user_enters_a_username(String username) {
        TestRunner.loginPage.sendUsername(username);
    }

    @When("The user enters password {string}")
    public void the_user_enters_a_password(String password) {
        TestRunner.loginPage.sendPassword(password);
    }

    @When("The user clicks the login button")
    public void the_user_clicks_the_login_button() {
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("The user should be logged in successfully and redirected to homepage")
    public void the_user_should_be_logged_in_successfully_and_redirected_to_homepage() {
        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(5));
        // Wait until the URL becomes the expected URL of the homepage
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/home"));
        // Now get the current URL and assert it
        String actualUrl = TestRunner.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/home", actualUrl);
    }
}