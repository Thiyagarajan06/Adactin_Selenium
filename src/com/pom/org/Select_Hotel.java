package com.pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Select_Hotel {
	public static WebDriver driver;
	
	@FindBy (id = "radiobutton_0")
	private WebElement select;
	
	@FindBy(id = "continue")
	private WebElement contd;

	public Select_Hotel(WebDriver driver2) {
		PageFactory.initElements(driver2, this);
	
	
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getContd() {
		return contd;
	}
	
	

}
