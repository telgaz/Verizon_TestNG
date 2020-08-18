package com.qa.verizon.page;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;




public class SmartPhonePage extends BasePage{

	//a[@id='thirdLevel00']===>smartPhones link locator	

	//button[contains(text(),'Phones list')]===>phones locator

		WebDriver driver;
		HomePage homePage;
		ElementUtil elementUtil;
		
		By phone=By.xpath("//button[contains(text(),'Phones list')]");
	    By smartPhone=By.id("thirdLevel00");
        By chosenPhone=By.xpath("//a[@aria-label='Apple iPhone 11']");
		
		public SmartPhonePage(WebDriver driver) {
			
			this.driver=driver;
			homePage=new HomePage(driver);
			elementUtil=new ElementUtil(driver);
		}
			
		public void verifyTitle ()  {
         
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  String title=driver.getTitle();
      System.out.println("Title is"+title);  
		}


		public  PhonePage choosePhone() {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("scroll(0, 300);");
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(chosenPhone));
			elementUtil.doClick(chosenPhone);
			
			return new PhonePage(driver);
			
		}
		
	
	
}
