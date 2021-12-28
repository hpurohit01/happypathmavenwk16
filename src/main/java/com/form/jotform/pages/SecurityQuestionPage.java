package com.form.jotform.pages;

import com.form.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SecurityQuestionPage extends Utility {
    public SecurityQuestionPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@id='input_11_field_1']")
    WebElement selectSequrityQestionDropDown;

    @FindBy(css = "#input_11_field_2")
    WebElement answerField;

    @FindBy(xpath = "//button[@class='jfInput-button forSubmit form-submit-button u-right']")
    WebElement nextButton;

    public void selectSecurityQuestion(String question){
        Reporter.log("Selecting security question: '" + question + "<br>");
        doSelectByVisibleTextFromDropDown(selectSequrityQestionDropDown,question);
    }

    public void enterAnswer(String answer){
        Reporter.log("Entering answer: '" + answer + "<br>");
        doSendTextToElement(answerField,answer);
    }

    public void clickOnNextButton(){
        Reporter.log("Clicking on next button: '" + nextButton.toString() + "<br>");
        doClickOnElement(nextButton);
    }
}
