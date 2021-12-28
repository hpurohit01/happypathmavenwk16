package com.form.jotform.pages;

import com.form.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NamePage extends Utility {
    public NamePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-type='control_fullname'] button[aria-label='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//div[@class='jfField']//input[@id='first_3']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@class='jfField']//input[@id='last_3']")
    WebElement lastNameField;

    public void enterFirstName(String firstName) {
        Reporter.log("Entering First name: '" + firstName + "<br>");
        doSendTextToElement(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        Reporter.log("Entering Last name: '" + lastName + "<br>");
        doSendTextToElement(lastNameField, lastName);
    }

    public void clickOnNextButton() {
        Reporter.log("Clicking on next button: '" + nextButton.toString() + "<br>");
        doClickOnElement(nextButton);
    }

}
