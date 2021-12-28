package com.form.jotform.pages;

import com.form.jotform.propertyreader.PropertyReader;
import com.form.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='jfCard-welcome-start']")
    WebElement nextButton;

    public void clickOnNextButton() {
        Reporter.log("Clicking on next button " + nextButton.toString() + "<br>");
        doClickOnElement(nextButton);
    }

    public void verifyHomePage() {
        Reporter.log("verifying homepage url : " + PropertyReader.getInstance().getProperty("baseUrl") + "<br>");
        String expected = PropertyReader.getInstance().getProperty("baseUrl");
        String actual = driver.getCurrentUrl();
        AssertJUnit.assertEquals(expected, actual);
    }
}