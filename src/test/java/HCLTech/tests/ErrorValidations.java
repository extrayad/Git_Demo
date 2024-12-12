package HCLTech.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import HCLTech.testsComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test (groups= {"ErrorHandling"})
	public void loginErrorValidations() throws IOException, InterruptedException {
		
		
		landingPage.loginApplication("rny@gmail.com", "Learnin");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void productErrorValidations() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("rny@gmail.com", "Learning@24");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);

	}

}
