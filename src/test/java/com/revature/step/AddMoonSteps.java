package com.revature.step;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AddMoonSteps {

    private String Moonname;

    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        try{
            TestRunner.loginPage.openLoginPage();
            TestRunner.loginPage.sendUsername("Batman");
            TestRunner.loginPage.sendPassword("I am the night");
            TestRunner.loginPage.clickLoginButton();
        }
        catch (UnhandledAlertException e){

        }
    }

    @When("The user should pick moon option from dropdown")
    public void the_user_should_pick_moon_option_from_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.selectPlanetToAdd();
        TestRunner.homePage.selectMoonToAdd();
    }

    @When("The user enters a {string}")
    public void the_user_enters_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        Moonname = string;
        TestRunner.homePage.sendMoonToAdd(string);
    }

    @When("The user enters Id {string}")
    public void the_user_enters_Id(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.sendPlanetToOrbit(string);
    }

    @When("The user provides a {string}")
    public void the_user_provides_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        String filepath = "C:\\Users\\vasd5\\OneDrive\\Desktop\\240701-JWA-Gen-AI\\Foundation Project\\setup\\src\\test\\resources\\Celestial-Images\\";
        if (!(string.isEmpty())) {
            filepath = filepath + string;
            TestRunner.homePage.sendMoonImageToInput(filepath);
        }
    }

    @When("The user enters a no image")
    public void the_user_enters_a_no_image() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.sendMoonImageToInput(null);
    }

    @When("The user clicks submit button")
    public void the_user_clicks_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.clickSubmit();
    }

    @Then("The new moon should be added")
    public void the_new_moon_should_be_added() {
        // Write code here that turns the phrase above into concrete actions
        Boolean flag = false;
        try{
            WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[contains(text(),\"" + Moonname + "\")]")));
            if (element.isDisplayed()){
                flag = true;
            }
        }
        catch (NoSuchElementException | UnhandledAlertException e){
            flag = false;
        }

        Assert.assertTrue("The moon is added.", flag);
    }

    @Then("The new moon should not be added")
    public void the_new_moon_should_not_be_added() {
        // Write code here that turns the phrase above into concrete actions
        Boolean flag = false;
        try{
            WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[contains(text(),\"" + Moonname + "\")]")));
            if (element.isDisplayed()){
                flag = true;
            }
        }
        catch (NoSuchElementException | UnhandledAlertException e){
            flag = false;
        }

        Assert.assertFalse("The moon is not added.", flag);
    }
}
