package com.revature;

import com.revature.pom.CreateAccountPage;
import com.revature.pom.HomePage;
import com.revature.pom.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.step",
        plugin = {
                "pretty",
                "html:src/test/resources/reports/html-report.html",
                "json:src/test/resources/reports/json-report.json"
        }
)

public class TestRunner {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static CreateAccountPage createAccountPage;
    public static HomePage homePage;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginPage = new LoginPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

