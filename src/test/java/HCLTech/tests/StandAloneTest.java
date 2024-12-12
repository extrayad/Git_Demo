package HCLTech.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HCLTech.testsComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {

	String productName = "ZARA COAT 3";
	@Test(dataProvider= "getData", groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException 
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToChekout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMsg = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		//driver.close();
	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistory()
	{
		//"ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("rny@gmail.com", "Learning@24");
		OrderPage orderPage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//HashMap<String, String> map= new HashMap<String, String>();
	//return	new Object[][] {{"rny@gmail.com","Learning@24","ZARA COAT 3"},{"shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
	
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\HCLTech\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	

}
