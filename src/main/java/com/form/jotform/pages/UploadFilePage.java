package com.form.jotform.pages;

import com.form.jotform.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class UploadFilePage extends Utility {

    public UploadFilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='jfUpload-container']//div//div[2]//div[@class='jfUpload-subheading']//span[contains(text(),'MB')]")
    WebElement fileSizeText;

    @FindBy(xpath = "//div[@data-type='control_fileupload']//div[@class='jfCard-actions']//button[2]")
    WebElement nextButton;

    @FindBy(xpath = "//ul[@class='qq-upload-list']//li[@actual-filename='file.docx']")
    WebElement uploadVerifyBox;

    @FindBy(xpath = "//div[@class='jfUpload-container']//div[2][@class='jfUpload-button-container']//label")
    WebElement browserFilesButton;

    public void uploadFile() {
        Reporter.log("Uploading file: '" + "<br>");
        //  WebElement addFile = driver.findElement(By.xpath("//div[@class='jfUpload-container']//div[2][@class='jfUpload-button-container']//label"));
        WebElement addFile = driver.findElement(By.cssSelector(".jfUpload-button"));
        // WebElement element = browserFilesButton.click();
        addFile.sendKeys("C:\\Users\\rjpat\\OneDrive\\Documents\\happypathFile\\file.txt");
        // doSendTextToElement(browserFilesButton,"C:\\Users\\rjpat\\OneDrive\\Documents\\happypathFile\\file.docx");
    }

    public void verifyFileUpload() {
        Reporter.log("verifying file upload: '" + "<br>");
        boolean actual = uploadVerifyBox.getText().contains("file");
        Assert.assertTrue(actual);
    }

    public void clickOnNextButton() {
        Reporter.log("Clicking on next button. '" + nextButton.toString() + "<br>");
        doClickOnElement(nextButton);
    }

}
