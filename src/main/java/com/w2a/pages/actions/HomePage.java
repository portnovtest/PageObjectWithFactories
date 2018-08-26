package com.w2a.pages.actions;

import com.w2a.base.Page;
import com.w2a.pages.locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Properties;

public class HomePage extends Page {

    public HomePageLocators home;

    public HomePage() {
        this.home = new HomePageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this.home);
    }

    public HomePage gotoFlights(){
        click(home.flightTab);
        return this;
    }

    public void gotoHotels(){

    }

    public void gotoFlightAndHotel(){

    }

    public int findTabCount(){
        return home.tabCount.size();
    }

    public void bookAFlight(String from, String to, String departing, String returning, String noOfAdults, String noOfChildren ){
        type(home.fromCity,from);
        type(home.toCity,to);
        type(home.departFlight,departing);
        type(home.returnFlight,returning);
        type(home.adultCount,noOfAdults);
        type(home.childCount,noOfChildren);
        type(home.firstAge,noOfAdults);
        type(home.secondAge,noOfChildren);
//        home.search.click()
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ESCAPE).perform();
//        home.block.click();
//        action.sendKeys(Keys.PAGE_DOWN).perform();
//        action.sendKeys(Keys.ENTER).perform();
        click(home.search);
    }



}
