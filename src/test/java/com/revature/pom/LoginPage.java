package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "http://localhost:8080";  // Ensure the URL is complete with http/https

    @FindBy(id = "usernameInput")
    WebElement usernameInput;

    @FindBy(id = "passwordInput")
    WebElement passwordInput;

    @FindBy(xpath = "/html/body/div[1]/form/input[3]")
    WebElement loginButton;    

    @FindBy(xpath = "/html/body/div/form/a")
    WebElement createAccountLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get(url);
    }

    public void sendUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
    }

    public void sendPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }
    
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
    
    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink));
        createAccountLink.click();
    }
}
