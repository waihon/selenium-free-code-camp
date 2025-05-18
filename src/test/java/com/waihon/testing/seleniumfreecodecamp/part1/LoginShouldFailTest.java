package com.waihon.testing.seleniumfreecodecamp.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginShouldFailTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:/opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username= wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        var password = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        password.sendKeys(("admin123"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button"))).click();

        String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h6"))).getText();
        String expectedResult = "Dashboard";
        Assert.assertNotEquals(actualResult, expectedResult);
    }
}
