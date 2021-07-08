package com.pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Hotel {
	public static WebDriver driver;
	
	@FindBy(id = "first_name")
	private WebElement cardname;
	
	@FindBy(id = "last_name")
	private WebElement cardlastname;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id =  "cc_num")
	private WebElement cardnumber;
	
	@FindBy(id = "cc_type")
	private WebElement cardType;
	
	@FindBy(id = "cc_exp_month")
	private WebElement expMonth;
	
	@FindBy(id ="cc_exp_year")
	private WebElement expyear;
	
	@FindBy(id = "cc_cvv")
	private WebElement cvv;
	
	@FindBy(id = "book_now")
	private WebElement bookNow;

	public Book_Hotel(WebDriver driver2) {
		PageFactory.initElements(driver2, this);
	}

	public WebElement getCardname() {
		return cardname;
	}

	public WebElement getCardlastname() {
		return cardlastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardnumber() {
		return cardnumber;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}
	
	
	
	
	

}
