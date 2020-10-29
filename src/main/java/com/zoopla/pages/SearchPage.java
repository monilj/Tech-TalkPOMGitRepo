package com.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;


    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    By header = By.xpath("//h1[contains(text(),'Property')]");

    public String validateHeader(){
        return driver.findElement(header).getText();
    }
}
