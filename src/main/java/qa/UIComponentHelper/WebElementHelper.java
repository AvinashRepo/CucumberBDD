package qa.UIComponentHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

import pages.PgSignUp;


public class WebElementHelper {
	
	private static WebDriver driver;
	private PgSignUp pgSignUp = new  PgSignUp(DriverFactory.getDriver());
	
	public static boolean isElementPresent(By locator) {
		try{			
			return driver.findElements(locator).size() == 1;			
		}catch(Exception e) {			
			return false;
		}
		
	}
	
	public static WebElement GetElement(By locator) {
		
		if(isElementPresent(locator)) {
			return driver.findElement(locator);
		}else {
			throw new NoSuchElementException("Element is not found" + locator.toString());
		}
		
	}
	
	
}
