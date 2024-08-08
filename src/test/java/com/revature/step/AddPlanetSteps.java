package com.revature.step;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPlanetSteps {

    @When("The user selects Planet from the drop down menu")
    public void the_user_selects_Planet_from_the_drop_down_menu() {
        TestRunner.homePage.selectPlanetToAdd();
        TestRunner.homePage.wait.until(ExpectedConditions.elementToBeClickable(TestRunner.homePage.planetNameInput));
    }

    @When("The user provides {string} for planet name")
    public void the_user_provides_planet_name(String string) {
        TestRunner.homePage.sendPlanetToAdd(string);
        TestRunner.homePage.wait.until(ExpectedConditions.textToBePresentInElementValue(TestRunner.homePage.planetNameInput, string));
    }

    @When("The user provides a valid planet image")
    public void the_user_provides_a_valid_planet_image() {
        TestRunner.homePage.sendPlanetImageToInput("C:\\Users\\shado\\revature\\Automation_Project\\src\\test\\resources\\images\\furina.jpg");
    }

    @When("The user clicks the Submit Planet button")
    public void the_user_clicks_the_Submit_Planet_button() {
        TestRunner.homePage.clickSubmit();
    }

    @Then("The {string} planet should be added to the planetarium")
    public void the_planet_should_be_added_to_planetarium(String name) {
        Assert.assertTrue(TestRunner.homePage.getPlanetInfo(name));
    }


    @Then("The {string} planet should not be added to the planetarium")
    public void the_planet_should_not_be_added_to_planetarium(String name) {
        TestRunner.homePage.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Something went wrong, please try again", alert.getText());
        alert.accept();
        TestRunner.homePage.wait.until(ExpectedConditions.elementToBeClickable(TestRunner.homePage.planetNameInput));
    }

    @When("The user provides an empty planet name")
    public void the_user_provides_an_empty_planet_name() {
        TestRunner.homePage.sendPlanetToAdd("");
    }

    @Then("The empty planet name should not be added to the planetarium")
    public void the_empty_planet_name_should_not_be_added_to_planetarium() {
        the_planet_should_not_be_added_to_planetarium("");
    }

    @When("The user provides an invalid image format")
    public void theUserProvidesAnInvalidImageFormat() {
        TestRunner.homePage.sendPlanetImageToInput("C:\\Users\\shado\\revature\\Automation_Project\\src\\test\\resources\\images\\planet.txt");
    }
}
