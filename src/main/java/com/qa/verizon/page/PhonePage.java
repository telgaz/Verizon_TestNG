package com.qa.verizon.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.google.common.base.Verify;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class PhonePage extends BasePage{


WebDriver driver;
ElementUtil elementUtil;
HomePage homePage;
SmartPhonePage smartPhonePage;
	
By color=By.xpath("//div[@class='  positionRelative color-swatch-selected borderRadius50 cursorPointer']");
By gb=By.xpath("//div[@class='sizePad']/p[contains(text(),'128GB')]");
By payment=By.xpath("(//div[@class='col-sm-12 noSidePad fontSize_16 fontDSStd-75Bd textAlignLeft contractDetail'])[1]");
By shipping=By.cssSelector("input[id='ship']");
By continueBtn=By.id("ATC-Btn");
By zipcode=By.cssSelector("button[type='submit']");
By newCustomer=By.xpath("//button[contains(text(),'New Customer')]");
By cartSign=By.xpath("//a[@class='cart-icon ']");
By cart=By.id("navCartCircle");

public PhonePage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
	homePage=new HomePage(driver);
	smartPhonePage=new SmartPhonePage(driver);
	
}
public void verifyTitle() {
	String title=elementUtil.doGetPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price");
}	
	
public CartPage selectPhone() {
	WebDriverWait wait =new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(color));

	elementUtil.clickOn(color);
	elementUtil.clickOn(gb);
	elementUtil.clickOn(payment);
	elementUtil.clickOn(continueBtn);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(zipcode));
	elementUtil.clickOn(zipcode);

	wait.until(ExpectedConditions.presenceOfElementLocated(newCustomer));
	elementUtil.clickOn(newCustomer);
	
	return new CartPage(driver);
	
}

	
	

	
}
