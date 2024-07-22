package SsquareIT.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponents.BaseTest;

public class VerifyInvalidLogin extends BaseTest {
	
    @Test
    public void verifyLoginWithInvalidCreds() throws IOException {
	WebDriver driver = initBrowser();
	LandingPage lp = new LandingPage(driver);
	LoginPage login = lp.NavigateToLoginPage();
	HomePage hp = login.LoginAction("valkarprashant14@gmail.com", "ashant@123");
	SoftAssert sa = new SoftAssert(); 
	String actual = driver.getCurrentUrl();
	String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
	sa.assertEquals(actual, expected);
	tearDown();
	sa.assertAll();
    }
}
