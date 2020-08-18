package com.qa.verizon.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.util.ElementUtil;

public class HomePageTest {

	WebDriver driver;
	HomePage homePage;
	BasePage basePage;
	Properties prop;
	ElementUtil elementUtil;
	
	
	@BeforeTest
	public void setup() {
		
		basePage =new BasePage();
		prop=basePage.init_properties();	
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
	}
	@Test(priority=1)
	public void verifyHomePageTitle() {
	
		String title =homePage.getHomePageTitle();
				
		System.out.println("Title is "+title);
	 
		Assert.assertEquals(title,"Verizon Wireless, Smartphone Deals & Plans | First to 5G");
	
	}
	
	@Test(priority=2)
	public void goToPhonePage() {

	homePage.moveToPageElement();
		
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
		
	
}
