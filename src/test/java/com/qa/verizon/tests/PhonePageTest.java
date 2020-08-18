package com.qa.verizon.tests;

import java.util.Properties;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.PhonePage;
import com.qa.verizon.page.SmartPhonePage;

public class PhonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartPhonePage smartPhonePage;
	PhonePage phonePage;
	
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

	}
	
	@Test(priority=1)
	public void pageTitleVerifyTest() {
		phonePage.verifyTitle();
		}
	@Test(priority=2)
	public void selectPhoneTest() {
		phonePage.selectPhone();
	}	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
}
