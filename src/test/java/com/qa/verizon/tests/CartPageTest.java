package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.CartPage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.PhonePage;
import com.qa.verizon.page.SmartPhonePage;

public class CartPageTest {

	 WebDriver driver;
	 BasePage basePage;
	 Properties prop;
	 HomePage homePage;
	 SmartPhonePage smartPhonePage;
     PhonePage phonePage;
	 CartPage cartPage;
	
	@BeforeTest
	public void setup() {
	
	basePage =new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	homePage=new HomePage(driver);
	smartPhonePage=homePage.moveToPageElement();
	smartPhonePage=new SmartPhonePage(driver);
	phonePage=smartPhonePage.choosePhone();
	phonePage=new PhonePage(driver);
	cartPage=phonePage.selectPhone();
	cartPage=new CartPage(driver);
	}
	@Test(priority=1)
	public void cartSignClickTest() {

	cartPage.clickOnCartSign();
	}
	@Test(priority=2)
	public void getTitleTest() {
		cartPage.getTitle();
		String actual=cartPage.getTitle();
		Assert.assertEquals(actual, "Verizon | Shopping Cart");
	}
	@Test(priority=3)
	public void verifyChosenPhoneTest() {
		cartPage.verifyChosenPhone();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
