package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.actions.HomePage;
import org.testng.Assert;

public class FlightSearchTest {

    public static void main(String[] args) {

        Page.initConfiguration();
        HomePage home = new HomePage();
        Assert.assertEquals(home.findTabCount(), 5);
        home.gotoFlights().bookAFlight("Delhi, India (DEL-Indira Gandhi Intl.)","Seattle, WA, United States (SEA-Seattle - Tacoma Intl.)",
               "12/12/2018", "12/14/2018","2","2");
        //Page.quitBrowser();
    }
}
