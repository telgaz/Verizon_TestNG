package com.qa.verizon.tests;

import java.awt.Desktop.Action;
import java.util.Properties;

import javax.swing.border.TitledBorder;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartPhonePage;
import com.qa.verizon.util.ElementUtil;

public class SmartPhonePageTest {
	

		WebDriver driver;
		BasePage basePage;
		Properties prop;
		HomePage homePage;
		SmartPhonePage smartPhonePage;
		
	    @BeforeTest
		public void setup() {
		
		basePage =new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));//this url is initiliazed in config properties
		homePage=new HomePage(driver);
		smartPhonePage=homePage.moveToPageElement();
		smartPhonePage=new SmartPhonePage(driver);
		}
	    @Test
	    public void verifyTitleTest() {
	    	smartPhonePage.verifyTitle();
	    }
	
	  @Test
	  public void choosePhoneTest() {
		  smartPhonePage.choosePhone();
	  }
	
	  @AfterTest
	  public void tearDown() {
		  driver.quit();
	  }
	
}

