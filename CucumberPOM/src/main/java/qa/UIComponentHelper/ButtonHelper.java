package qa.UIComponentHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ButtonHelper  {

	private static WebElement element;
	
	public static void clickOnButton(By locator) {
		
		element = WebElementHelper.GetElement(locator);
		element.click();
	}
	
}
