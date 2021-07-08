package com.Baseclass.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class My_Baseclass {
	public static WebDriver driver;
	
//========================Browser Launching==============================================================	
	public static WebDriver browserLaunc(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ("\\Driver\\chromedriver.exe"));
			 driver = new ChromeDriver();
}

else if (browser.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ("\\Driver\\firefoxdriver.exe"));
			driver = new FirefoxDriver();
}
else {
			System.out.println("Invalid Browser");
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
//====================================url================================================================
	public static void url(String value) {
		driver.get(value);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//====================================Send keys==========================================================
	
public static void inputOfElement(WebElement element, String value) {
	element.sendKeys(value);
}

//=======================================Click=============================================================

public static void ClickOnElement(WebElement element) {
	element.click();
}

//=======================================Clear============================================================

public static void clearOnElement(WebElement element) {
	element.clear();

}

//===================================isEnabled============================================================

public static void enabled(WebElement element) {
	element.isEnabled();

}

//==================================isDisplayed===========================================================

public static void displayed(WebElement element) {
	element.isDisplayed();
	
}

//==================================is Selected===========================================================

public static void selected(WebElement element) {
	System.out.println(element.isSelected());

}

//==================================Multiple=============================================================

public static void multiple(WebElement element) {
	Select s = new Select(element);
	s.isMultiple();
	
}

//==============================get title===============================================================
public static void title() {
	driver.getTitle();

}

//==============================get text================================================================

public static void text(WebElement element) {
	element.getText();

}

//============================DropDown==================================================================

public static void dropDown(WebElement element, String Options, String value) {
	Select s = new Select(element);
	try {
		if (Options.equalsIgnoreCase("byIndex")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
			}
		else if (Options.equalsIgnoreCase("byValue")) {
			s.selectByValue(value);	
		}
		
		else if (Options.equalsIgnoreCase("byVisibleText")) {
			s.selectByVisibleText(value);
		}
		
		else {
			System.out.println("Invalid selection");
		}
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
}

//===========================================sleep=========================================

public static void sleep() throws InterruptedException {
	Thread.sleep(3000);
}

//====================================Close================================================

public static void close() {
	driver.close();

}

//=====================================Quit=================================================

public static void quit() {
	driver.quit();

}

//===================================Navigate to=============================================

public static void navigateTo(String value) {
	driver.navigate().to(value);
}

//===================================navigate back===========================================

public static void navigateBack() {
	driver.navigate().back();

}

//=====================================navigateForward=======================================

public static void navigateForward() {
	driver.navigate().forward();

}

//=====================================navigate Refresh======================================

public static void navigateRefresh() {
	driver.navigate().refresh();

}

//====================================Get current url=========================================

public static void currentUrl() {
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);

}

//=====================================CheckBox===============================================

public static void checkbox(WebElement element) {
	if (element.isSelected()) {
		element.click();
		}
}

//======================================Get Options===========================================

public static void getOptions(WebElement element) {
	Select s = new Select(element);
	List<WebElement> options = s.getOptions();
	System.out.println(options);
}

//======================================Get All selected options==============================

public static void allSelected(WebElement element) {
	Select s = new Select(element);
	List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	System.out.println(allSelectedOptions);
}

//======================================get first selected option============================

public static void firstSelected(WebElement element) {
	Select s = new Select(element);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	System.err.println(firstSelectedOption);
}

//======================================Get Attribute========================================

public static void getAttribute(WebElement element, String value) {
	String attribute = element.getAttribute(value);
	System.out.println(attribute);
}

//=====================================JAVA-SCRIPT-EXE-SCROLL=================================

public static void scroll(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollInToView();", element);
}

//===================================ScreenShot=============================================

public static void screenshot(String string) throws Throwable   {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	File desFile = new File(string);
	FileUtils.copyFileToDirectory(srcFile, desFile);
	
}

//============================Robot========================================================

public static void robot(String Options) throws AWTException {
	Robot r = new Robot();
	try {
		if (Options.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			}
		else if (Options.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			}
		else {
			System.out.println("Invalid selection");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//=======================Actions==================================================================

public static void actions(WebElement element, String Options, WebElement drop) {
	Actions ac = new Actions(driver);
	
	try {
		if (Options.equalsIgnoreCase("moveToElement")) {
			ac.moveToElement(element).build().perform();
			}
		else if (Options.equalsIgnoreCase("draganddrop")) {
			ac.dragAndDrop(element, drop).build().perform();
			}
		else if (Options.equalsIgnoreCase("rightClick")) {
			ac.contextClick().build().perform();
			}
		else if (Options.equalsIgnoreCase("click")) {
			ac.click().build().perform();
			}
		else {
			System.out.println("Invalid mouse selection");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//==============================Window Handling=================================================

public static void windowHandling() {
	String s = driver.getWindowHandle();
	System.out.println(s);
	
	String title = driver.getTitle();
	System.err.println(title);
}

//================================Id and Title==================================================

public static void idAndTitles() {
	Set<String> handles = driver.getWindowHandles();
	for (String s : handles) {
		System.out.println(s);
		
		String title = driver.switchTo().window(s).getTitle();
		System.out.println(title);
		}
}

//=====================number of windows=========================================================

public static void numOfWindows() {
	int size = driver.getWindowHandles().size();
	System.out.println("Number of windows" + size);
}

//======================Frames===================================================================
//===============================================================================================

public static void frameByIndex(int i) {
	driver.switchTo().frame(i);
}

public static void frameByString(String value) {
	driver.switchTo().frame(value);
}

public static void findByElement(WebElement element) {
	driver.switchTo().frame(element);
}

public static void frameMain() {
	driver.switchTo().defaultContent();
}

//===============================================================================================

}









	
	

	


