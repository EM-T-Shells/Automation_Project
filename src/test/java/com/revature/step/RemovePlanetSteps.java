package com.revature.step;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RemovePlanetSteps {

    @When("The user provides a planet name: {string}")
    public void the_user_provides_a_planet_name(String name) {
        TestRunner.homePage.sendNameToDelete(name);
    }


    @When("The user clicks the Delete button")
    public void theUserClicksTheDeleteButton() {
        TestRunner.homePage.clickDelete();
    }

    @Then("The planet, {string}, should be removed from the planetarium")
    public void thePlanetShouldBeRemovedFromThePlanetarium(String name) {
        Assert.assertFalse(TestRunner.homePage.checkCelestialBody(name));
    }

    @Then("The planet should fail to be deleted")
    public void thePlanetShouldFailToBeDeleted() {
        TestRunner.homePage.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Failed to delete planet with name ", alert.getText());
        alert.accept();
        TestRunner.homePage.wait.until(ExpectedConditions.elementToBeClickable(TestRunner.homePage.planetNameInput));
    }
}
