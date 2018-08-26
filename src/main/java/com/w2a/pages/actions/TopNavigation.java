package com.w2a.pages.actions;

import com.w2a.base.Page;
import com.w2a.pages.locators.TopNavigationLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TopNavigation {

    public TopNavigationLocators topNavigation;

    public TopNavigation(WebDriver driver) {
        this.topNavigation = new TopNavigationLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this.topNavigation);
    }

    public SigninPage gotoSignIn(){
        Page.click(topNavigation.account);
        Page.click(topNavigation.signinBtn);
        return new SigninPage();
    }

    public void gotoCreateAccount(){

    }

    public void gotoList(){

    }

    public void gotoSupport(){

    }
    public void gotoHome(){

    }

    public void gotoFlights(){

    }
}
