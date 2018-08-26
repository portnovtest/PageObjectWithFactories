package com.w2a.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePageLocators {

    @FindBy(xpath = "//*[starts-with(@id,'tab-flight-tab')]")
    public WebElement flightTab;

    //locators for flight booking
    @FindBy(css = "input[id^='flight-origin']")
    public WebElement fromCity;
    @FindBy(css = "input[id^='flight-destination']")
    public WebElement toCity;
    @FindBy(css = "#flight-departing-hp-flight")
    public WebElement departFlight;
    @FindBy(css = "#flight-returning-hp-flight")
    public WebElement returnFlight;
    @FindBy(css = "#flight-adults-hp-flight")
    public WebElement adultCount;
    @FindBy(css = "#flight-children-hp-flight")
    public WebElement childCount;
    @FindBy(css = "#gcw-flights-form-hp-flight .gcw-submit")
    public WebElement search;
    @FindBys({
            @FindBy(css = ".cols-nested.children-data.gcw-toggles-fields.available-for-flights"),
            @FindBy(id = "flight-age-select-1-hp-flight" )
    })
    public WebElement firstAge;
    @FindAll({
            @FindBy(css = "#flight-age-select-222-hp-flight"),
            @FindBy(id = "flight-age-select-2-hp-flight" )
    })

    public WebElement secondAge;
    @FindBy(css = ".cols-nested.children-data.gcw-toggles-fields.available-for-flights")
    public WebElement block;
    @FindBy(css = "li[role='presentation']")
    public List<WebElement> tabCount;
}
