package com.zoopla.pages;

import org.openqa.selenium.*;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By toRent = By.id("search-tabs-to-rent");
    By searchBox = By.name("q") ;


    public String getTitle(){
       return driver.getTitle();
    }

    public boolean validateToRentOption(){
       return driver.findElement(toRent).isDisplayed();
    }

    public SearchPage enterCity() throws InterruptedException {
        Thread.sleep(4000);
        WebElement element =  driver.findElement(searchBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        driver.findElement(searchBox).sendKeys("London");
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }
}
