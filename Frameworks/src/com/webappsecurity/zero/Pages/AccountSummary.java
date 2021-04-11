package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummary {

	@FindBy(id = "transfer_funds_link")
	private WebElement transferFunds;
	
	public AccountSummary(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickTrasferFunds() {
		transferFunds.click();
	}
	
	
}
