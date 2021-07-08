package com.Baseclass.org;

import org.openqa.selenium.remote.server.handler.SendKeys;

import com.Baseclass.org.My_Baseclass;
import com.pom.org.Book_Hotel;
import com.pom.org.Login_Page;
import com.pom.org.Search_Hotel;
import com.pom.org.Select_Hotel;

public class Adactin_Project extends My_Baseclass {
	
	public static void main(String[] args) {
		
//==============================================LoginPage======================================		
		browserLaunc("chrome");
		url("https://adactinhotelapp.com/");
		
		Login_Page lp = new Login_Page(driver);
		
		inputOfElement(lp.getUsername(), "vinovicky");
		inputOfElement(lp.getPassword(), "Jan@2020");
		ClickOnElement(lp.getLogin());
	
	
//============================================Search Hotels=================================	
	Search_Hotel sh = new Search_Hotel(driver);
	dropDown(sh.getLocation(), "byValue", "Melbourne");
	dropDown(sh.getHotels(), "byValue", "Hotel Sunshine");
	dropDown(sh.getRoomtype(), "byValue", "Super Deluxe");
	dropDown(sh.getRoomnos(), "byValue", "1");
	clearOnElement(sh.getDatepick());
	inputOfElement(sh.getDatepick(), "06/06/2021");
	clearOnElement(sh.getDateout());
	inputOfElement(sh.getDateout(), "8/6/2021");
	dropDown(sh.getAdultroom(), "byValue", "2");
	dropDown(sh.getChildRoom(), "byValue", "0");
	ClickOnElement(sh.getSubmit());
	
	
//========================================Select hotel=======================================
	
	Select_Hotel sg = new Select_Hotel(driver);
	ClickOnElement(sg.getSelect());
	ClickOnElement(sg.getContd());
	
	
//=====================================Book a hotel==========================================
	
	Book_Hotel bh = new Book_Hotel(driver);
	inputOfElement(bh.getCardname(), "Thiyagarajan");
	inputOfElement(bh.getCardlastname(), "V");
	inputOfElement(bh.getAddress(), "Thanjavur");
	inputOfElement(bh.getCardnumber(), "6666666666666666");
	dropDown(bh.getCardType(), "byValue", "VISA");
	dropDown(bh.getExpMonth(), "byValue", "6");
	dropDown(bh.getExpyear(), "byValue", "2022");
	inputOfElement(bh.getCvv(), "666");
	ClickOnElement(bh.getBookNow());
	
	
	}

}
