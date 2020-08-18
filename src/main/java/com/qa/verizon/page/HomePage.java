package com.qa.verizon.page;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage{
	
    WebDriver driver;
	ElementUtil elementUtil;

	
	
	By phonesElement=By.xpath("//button[contains(text(),'Phones list')]");
	By smartPhone=By.xpath("//div[@id='tile_dev12360040']"
			+ "//div[contains(@class,'NHaasTX75Bd marginBottom5')]"
			+ "//span[1]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver.getTitle();
	
		
	}
	public  SmartPhonePage moveToPageElement() {
	
		WebElement smartElement=driver.findElement(By.id("thirdLevel00"));
		elementUtil.mouseOverClick(phonesElement,smartElement );
	    return new SmartPhonePage(driver);
		
	}
	
	

}
