package com.form.jotform.testsuite;

import com.form.jotform.pages.*;
import com.form.jotform.testbase.TestBase;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestSuite extends TestBase {


    CalenderPage calenderPage;
    HomePage homePage;
    NamePage namePage;
    SecurityQuestionPage securityQuestionPage;
    SignaturePage signaturePage;
    SubmissionPage submissionPage;
    UploadFilePage uploadFilePage;

    @BeforeMethod
    public void init() {
        calenderPage = new CalenderPage();
        homePage = new HomePage();
        namePage = new NamePage();
        securityQuestionPage = new SecurityQuestionPage();
        signaturePage = new SignaturePage();
        submissionPage = new SubmissionPage();
        uploadFilePage = new UploadFilePage();
    }

    @Test
    @Parameters({"firstName", "lastName", "question", "answer", "expectedMessage"})
    public void testingHappyPath(String firstName, String lastName, String question, String answer, String expectedMessage) {
        new HomePage().verifyHomePage();
        new HomePage().clickOnNextButton();
        new NamePage().enterFirstName(firstName);
        new NamePage().enterLastName(lastName);
        new NamePage().clickOnNextButton();

        new UploadFilePage().clickOnNextButton();
        new SignaturePage().signaturePerform();
        new SignaturePage().clickOnNextButton();
        new CalenderPage().selectDateOfBirth();
        new CalenderPage().clickOnNextButton();
        new SecurityQuestionPage().selectSecurityQuestion(question);
        new SecurityQuestionPage().enterAnswer(answer);
        new SecurityQuestionPage().clickOnNextButton();
        new SubmissionPage().verifySubmission(expectedMessage);
    }

}