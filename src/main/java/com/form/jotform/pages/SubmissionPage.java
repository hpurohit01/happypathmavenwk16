package com.form.jotform.pages;

import com.form.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SubmissionPage extends Utility {
    public SubmissionPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'Your submission has been received!')]")
    WebElement submissionMessage;

    public void verifySubmission(String expected){
        Reporter.log("veryfying submission text: '" + submissionMessage.toString() + "<br>");
        String actual = submissionMessage.getText();
        Assert.assertEquals(actual, expected,"Submission message did not match");
    }


}
