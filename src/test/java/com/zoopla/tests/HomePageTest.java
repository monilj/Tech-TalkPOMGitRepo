package com.zoopla.tests;

import com.zoopla.pages.HomePage;
import com.zoopla.pages.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;



    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.zoopla.co.uk/");
        driver.findElement(By.cssSelector(".ui-button-primary.ui-cookie-accept-all-medium-large")).click();
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void pageTitleTest(){
        Assert.assertTrue(homePage.getTitle().contains("Zoopla > "));
    }


    @Test(priority = 2)
    public void validateRentOptions() throws InterruptedException {
        Assert.assertTrue(homePage.validateToRentOption());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
