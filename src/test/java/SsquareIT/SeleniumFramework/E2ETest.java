package SsquareIT.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ETest {

	@Test
	public void endToEndTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wb = new  WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		// landing page 
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//li//a[text( )='Login']")).click();
					
		// login page
		driver.findElement(By.id("input-email")).sendKeys("savalkarprashant14@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Prashant@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		//home page 
		driver.findElement(By.xpath("//li//a[text()='Cameras']")).click();
		
		// product page 
	    List<WebElement> products = driver.findElements(By.cssSelector("div.product-grid"));
	    
	    for(WebElement product : products) {
	    	WebElement targetProduct = product.findElement(By.cssSelector("div h4"));
	    	String productName = targetProduct.getText();
	    	System.out.println(productName);
	    	if(productName.equalsIgnoreCase("Nikon D300")) {
	    		targetProduct.findElement(By.cssSelector("a")).click();
	    	}
	    	  	
	    }
		// product details page
	    
	    String price = driver.findElement(By.xpath("//h1[text()='Nikon D300']/..//"
	    		+ "following-sibling::ul[@class='list-unstyled'][2]//h2")).getText();
	    System.out.println("Product price: " + price);
	    
		// first validation 
	    Assert.assertEquals(price, "$98.00");
	    
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2");
		
		driver.findElement(By.id("button-cart")).click();
		driver.findElement(By.xpath("//span[@id='cart-total']/..")).click();
		String totalPrice = driver.findElement(By.xpath("//strong[text()='Total']/../following-sibling::td")).getText();
		System.out.println("TotalPrice: " +totalPrice);
				
	    Assert.assertEquals(totalPrice, "$196.00");
	    
	    driver.findElement(By.xpath("//strong[text()='Checkout']")).click();
		
	    driver.findElement(By.xpath("//div//a[text()='Checkout']")).click();
	    
	    driver.findElement(By.cssSelector("button.close")).click();
		String successMassage = driver.findElement(By.xpath("(//a[text()='Nikon D300'])[2]/../span")).getText();
	    
	    System.out.println("Success Massage: " +successMassage);
	    
	    boolean isSuccess = successMassage.equalsIgnoreCase("***");
	    Assert.assertTrue(isSuccess);
	    
	    driver.close();
		
	}
}
