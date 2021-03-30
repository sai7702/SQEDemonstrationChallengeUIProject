package com.sample.test.demo.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

public class DemoTest extends TestBase {
	testObjects testdata = new testObjects();


	@Test
	public void demoTest() throws InterruptedException {

		// size of the pizza is selected
		Select pizza= new Select(driver.findElement(By.id("pizza1Pizza")));
		pizza.selectByValue("Small 6 Slices - no toppings");
		// topping 1 for the pizza is selected
		Select Toppings_1 = new Select(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")));
		Toppings_1.selectByValue("Olives");
		// topping 2 for the pizza is selected
		Select Toppings_2 = new Select(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")));
		Toppings_2.selectByValue("Parmesan cheese");

		driver.findElement(By.id("pizza1Qty")).sendKeys("1");
		driver.findElement(By.id("pizza1Cost")).click();
		// name, email, phonenumber are sensitive information so they are encapsulated in another class and called here
		// by creating an object of the class.
		driver.findElement(By.id("name")).sendKeys(testdata.name);
		driver.findElement(By.id("email")).sendKeys(testdata.email);
		// as phone number is an intger we are sonverting to string and sending the value 
		driver.findElement(By.id("phone")).sendKeys(String.valueOf(testdata.phone));

		// mode of payment selection 
		driver.findElement(By.id("ccpayment")).click();
		// Place order 
		driver.findElement(By.id("placeOrder")).click();
		// checking the order status 
		String orderStatus = driver.findElement(By.xpath("//div[@id='dialog']/p")).getText();
		// clicking on the into mark on the dialouge box
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/button/span[1]")).click();
		// resetting the index.html page options 
		driver.findElement(By.id("reset")).click();

		// printing the success full order status
		System.out.println(orderStatus);
	}

	@Test
	public void ErrorTest() throws InterruptedException {


		Select pizza= new Select(driver.findElement(By.id("pizza1Pizza")));
		pizza.selectByValue("Large 10 Slices - no toppings");

		// Place order 
		driver.findElement(By.id("placeOrder")).click();
		// checking the order status 
		String errorStatus = driver.findElement(By.xpath("//div[@id='dialog']/p")).getText();
		// clicking on the cross mark on the dialouge box
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/button/span[1]")).click();
		// resetting the index.html page options 
		driver.findElement(By.id("reset")).click();
		// printing the error status 
		System.out.println(errorStatus);
	}
}