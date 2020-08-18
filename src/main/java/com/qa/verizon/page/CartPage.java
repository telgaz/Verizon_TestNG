package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class CartPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	SmartPhonePage smartPhonePage;
	PhonePage phonePage;
    String title="New Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price";
	
	By cartSign=By.xpath("//a[@class='cart-icon ']");
	By cart=By.id("navCartCircle");
	By phoneSelected=By.xpath("//span[contains(text(),'iPhone 11')]");
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		homePage=new HomePage(driver);
		smartPhonePage=new SmartPhonePage(driver);
		phonePage=new PhonePage(driver);
		
	}
	public void clickOnCartSign() {
	    WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartSign));
		elementUtil.clickOn(cartSign);
		}
	                         
	public String getTitle() {
		return elementUtil.doGetPageTitle();
	}
	public void verifyChosenPhone() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(phoneSelected));
		elementUtil.doGetText(phoneSelected);
	}
}
