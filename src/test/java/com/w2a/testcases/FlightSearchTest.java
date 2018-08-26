package com.w2a.testcases;

import com.w2a.base.Page;
import com.w2a.errorcollectors.ErrorCollector;
import com.w2a.pages.actions.HomePage;
import com.w2a.utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class FlightSearchTest {

    @BeforeTest
    public void setUp(){
        Page.initConfiguration();
    }

    @Test(dataProviderClass = Utilities.class,dataProvider = "dp")
    public void flightSearchTest(Hashtable<String,String> data){
        HomePage home = new HomePage();
        //Assert.assertEquals(home.findTabCount(), 6);
        ErrorCollector.verifyEquals(home.findTabCount(), 6);
//        ErrorCollector.verifyEquals(home.findTabCount(), 7);
//        ErrorCollector.verifyEquals(home.findTabCount(), 5);
        home.gotoFlights().bookAFlight(data.get("fromCity"),data.get("toCity"),
               data.get("fromDate"), data.get("toDate"),data.get("noOfAdults"),data.get("noOfChildren"));
    }

    @AfterMethod
    public void tearDown(){
        if (Page.driver!=null)
            Page.quitBrowser();
    }
}
