package com.revature.step;

import com.revature.TestRunner;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.io.File;
import java.nio.file.Files;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCelestialBodiesSteps {

    
    @Given("The user is not logged in")
    public void the_user_is_not_logged_in() {
        TestRunner.homePage.clickLogout();
        TestRunner.driver.navigate().to("http://localhost:8080/planetarium");
    }

    @When("The user is logged in with username {string} and password {string}")
    public void the_user_is_logged_in_with_username_and_password(String username, String password) {
        TestRunner.loginPage.openLoginPage();
        TestRunner.loginPage.sendUsername(username);
        TestRunner.loginPage.sendPassword(password);
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("The user should view celestial bodies page")
    public void the_user_should_view_celestial_bodies_page() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(10));
        WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(3)")));     
        Assert.assertTrue("The table is visible on the page.", tableElement.isDisplayed());
        takeScreenshot("HomePage");
    }


    @Then("The user should not view celestial bodies page")
    public void the_user_should_not_view_celestial_bodies_page() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/pre")));
        
        String messageText = messageElement.getText();
        Assert.assertTrue(messageText.contains("Please log in first"));
    }

    private void takeScreenshot(String filename) {
        File screenshot = ((TakesScreenshot) TestRunner.driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = "src/test/resources/screenShots/" + filename + ".png";
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
            System.out.println("Screenshot saved as: " + screenshotPath);
            System.out.println("Absolute path: " + new File(screenshotPath).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
