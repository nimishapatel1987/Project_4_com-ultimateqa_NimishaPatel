package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on the 'Sign In' link
        clickOnElement(By.xpath("//li[@class = 'header__nav-item header__nav-sign-in']"));
        //verify the text 'Welcome Back!'
        String expectedMessage = "Welcome Back!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class = 'page__heading']"));
        //valid actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessagewithInvalidCredentials() {
        //click on login link
        clickOnElement(By.linkText("Sign In"));

        //Enter invalid username
        sendTextToElement(By.id("user[email]"), "test1234@gmail.com");

        //Enter invalid password
        sendTextToElement(By.name("user[password]"), "12345");

        //click on login button
        clickOnElement(By.xpath("//input[@type='submit']"));

        getTextFromElement(By.xpath("//li[@class = 'form-error__list-item']"));

        //This is from requirement
        String expectedMessage = "Invalid email or password.";
        //Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//li[@class = 'form-error__list-item']"));
        //validate actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
