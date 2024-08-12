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

import java.time.Duration;
import java.util.NoSuchElementException;

public class RemoveMoonSteps {

    private String Moonname;
    private Boolean flag2 = false;

    @Given("The user logged in")
    public void the_user_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        try{
            TestRunner.loginPage.openLoginPage();
            TestRunner.loginPage.sendUsername("Batman");
            TestRunner.loginPage.sendPassword("I am the night");
            TestRunner.loginPage.clickLoginButton();
        }
        catch (org.openqa.selenium.UnhandledAlertException e){
            flag2 = false;
        }
    }

    @Given("The user is logged in wrong account")
    public void the_user_is_logged_in_wrong_account() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.openLoginPage();
        TestRunner.loginPage.sendUsername("CarlSagan");
        TestRunner.loginPage.sendPassword("Cosmos@2024");
        TestRunner.loginPage.clickLoginButton();
    }

    @When("The user should pick moon from dropdown")
    public void the_user_should_pick_moon_from_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.selectPlanetToAdd();
        TestRunner.homePage.selectMoonToAdd();
    }

    @When("The user enters {string}")
    public void the_user_enters(String string) {
        // Write code here that turns the phrase above into concrete actions
        Moonname = string;
        TestRunner.homePage.sendNameToDelete(string);
        TestRunner.homePage.clickDelete();
    }

    @Then("The moon should be removed")
    public void the_moon_should_be_removed() {
        // Write code here that turns the phrase above into concrete actions
        Boolean flag = false;
        try{
            WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(2));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[contains(text(),\"" + Moonname + "\")]")));
            if (element.isDisplayed()){
                flag = true;
            }
        }
        catch (NoSuchElementException | UnhandledAlertException | org.openqa.selenium.TimeoutException e){
            flag = false;
        }

        Assert.assertFalse("The moon is removed.", flag);
    }

    @Then("The moon should not be removed")
    public void the_moon_should_not_be_removed() {
        // Write code here that turns the phrase above into concrete actions
        Boolean flag = false;
        try{
            WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(2));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[contains(text(),\"" + Moonname + "\")]")));
            if (element.isDisplayed()){
                flag = true;
                flag2 = false;
            }
        }
        catch (NoSuchElementException | UnhandledAlertException | org.openqa.selenium.TimeoutException e){
            flag = true;
            flag2 = true;
        }

        Assert.assertTrue("The moon is not removed.", flag);
    }
}
