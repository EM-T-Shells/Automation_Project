package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    private WebDriver driver;

    private String url = "localhost:8080/register";

    @FindBy(id = "usernameInput")
    WebElement usernameInput;

    @FindBy(id = "passwordInput")
    WebElement passwordInput;

    @FindBy(xpath = "/html/body/div/form/input[3]")
    WebElement createButton;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCreateAccountPage() {
        driver.get(url);
    }

    public void sendUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void sendPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickCreateButton() {
        createButton.click();
    }
}
