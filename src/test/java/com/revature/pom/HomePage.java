package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {
    private final WebDriver driver;
    public final WebDriverWait wait;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(xpath = "//html//body//div[1]//select//option[@value = 'planet']")
    private WebElement selectPlanet;

    @FindBy(xpath = "//html//body//div[1]//select//option[@value = 'moon']")
    private WebElement selectMoon;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "planetNameInput")
    public WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(xpath = "//html//body//div[1]//div[2]//button")
    private WebElement submitButton;

    @FindBy(id = "celestialTable")
    private WebElement table;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public List<WebElement> getTableRows() {
        return table.findElements(By.tagName("tr"));
    }

    public WebElement getCellData(int row, int col) {
        List<WebElement> rows = getTableRows();
        WebElement selectedRow = rows.get(row);
        List<WebElement> cols = selectedRow.findElements(By.tagName("td"));
        return cols.get(col);
    }

    public boolean getPlanetInfo(String name) {
        try {
            table.findElement(By.xpath("//tr/td[contains(text(),\"" + name + "\")]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void sendNameToDelete(String name) {
        deleteInput.sendKeys(name);
    }

    public void selectPlanetToAdd() {
        selectPlanet.click();
    }

    public void sendPlanetToAdd(String name) {
        planetNameInput.sendKeys(name);
    }

    public void sendPlanetImageToInput(String filepath) {
        planetImageInput.sendKeys(filepath);
    }

    public void selectMoonToAdd() {
        selectMoon.click();
    }

    public void sendMoonToAdd(String name) {
        moonNameInput.sendKeys(name);
    }

    public void sendMoonImageToInput(String filepath) {
        moonImageInput.sendKeys(filepath);
    }

    public void sendPlanetToOrbit(String id) {
        orbitedPlanetInput.sendKeys(id);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}