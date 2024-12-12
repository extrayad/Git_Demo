package HCLTech.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//a[@class='btn1']")).click();
		driver.findElement(By.id("firstName")).sendKeys("RNY");
		driver.findElement(By.id("lastName")).sendKeys("Yadav");
		driver.findElement(By.id("userEmail")).sendKeys("rny@gmail.com");
		driver.findElement(By.id("userMobile")).sendKeys("9898989898");
		
	WebElement	dropDown= driver.findElement(By.cssSelector(".custom-select"));
	
	Select options= new Select(dropDown);
	options.selectByIndex(3);
	
	driver.findElement(By.xpath("//input[@value='Male']")).click();
	driver.findElement(By.id("userPassword")).sendKeys("Learning@24");
	driver.findElement(By.id("confirmPassword")).sendKeys("Learning@24");
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("//input[@type='checkbox']")).click();

	}

}
