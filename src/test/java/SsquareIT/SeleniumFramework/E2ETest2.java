package SsquareIT.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class E2ETest2 extends BaseTest {

	@Test (dataProvider="getData")
	public void endToEndTest(String username,String password) throws IOException {
		WebDriver driver = initBrowser();
		LandingPage lp = new LandingPage(driver);
		LoginPage login = lp.NavigateToLoginPage();
		HomePage hp = login.LoginAction(username, password);  
		ProductPage pp = hp.clickOnCameraTab();
		ProductDetails productDetails = pp.addProductToCart("Nikon D300");
	    Assert.assertEquals(productDetails.getPrice(), "$98.00");
	    CartPage cartPage = productDetails.setQuantity("2");
	//	Assert.assertEquals(cartPage.getPrice(), "$196.00");
		CheckOutPage checkOutPage = cartPage.goToCheckOutPage();
	    checkOutPage.clickToCheckOut(); 
	    checkOutPage.closeErrorMassage();
	    boolean isSuccess = checkOutPage.getSuccessMassage().equalsIgnoreCase("***");
	    Assert.assertTrue(isSuccess);
	    
	    tearDown(); 	
	}
	
	@DataProvider(name="getData")
	public Object[][]getData() {
		return new Object[][] {{"savalkarprashant14@gmail.com", "Prashant@123"},
			{"prashantsavalkar1412@gmail.com", "Prashant@1234"}};
		
		
	}
	
}
