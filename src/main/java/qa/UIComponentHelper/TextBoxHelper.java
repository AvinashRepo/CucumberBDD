package qa.UIComponentHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {
	
	private static WebElement element;

	public static void TypeInTextBox(By locator, String text) {
		
		element = WebElementHelper.GetElement(locator);
		element.clear();
		element.sendKeys(text);
	}
}
