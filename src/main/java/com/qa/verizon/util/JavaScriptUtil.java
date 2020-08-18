package com.qa.verizon.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;

public class JavaScriptUtil extends BasePage{

	public static void specificScrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0, 500);");
	}	
	
	
	
}
