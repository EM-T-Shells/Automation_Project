package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private String url = "http://localhost:8080"; 

    public WebDriverWait wait;

    @FindBy(id = "usernameInput")
    WebElement usernameInput;

    @FindBy(id = "passwordInput")
    WebElement passwordInput;
    
    @FindBy(xpath = "/html/body/div/form/input[3]")
    WebElement loginButton;    

    @FindBy(xpath = "/html/body/div/form/a")
    WebElement createAccountLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        //added WebDriverWait to prevent "cannot locate element" error
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get(url);
    }

    public void sendUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void sendPassword(String password) {
        passwordInput.sendKeys(password);
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }
    
    public void clickCreateAccount() {
        createAccountLink.click();
    }
}
