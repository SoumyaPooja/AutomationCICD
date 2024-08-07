package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=rahulshettyacademy.TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException
	{
		String productName="ZARA COAT 3";
		landingPage.loginApplication("soumyac@gmail.com", "Soumya123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("schickmath@gmail.com", "Soumya@1993");
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);		
		CartPage cartPage=productCatalogue.goToCartPage();
		Boolean match=cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
		
	}
}
