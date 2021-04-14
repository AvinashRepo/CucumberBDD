package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.UIComponentHelper.WebElementHelper;

public class PgSignUp {

	private WebDriver driver;
	
	//1. By locators
	public By lnkSignUp = By.xpath("//*[text()='Sign up']");
	private By txtBxUserName = By.xpath("//input[@placeholder='Username']");
	private By txtBxEmail = By.xpath("//input[@placeholder='Email']");
	private By txtBxPassword = By.xpath("//input[@placeholder='Password']");
	private By btnSignIn = By.xpath("//button[text()='Sign in']");
	private By lnkSettings = By.xpath("//a[@href='#settings']");
	private By txtBxProfPicUrl = By.xpath("//input[@placeholder='URL of profile picture']");
	private By btnUpdateSettings = By.xpath("//*[text()='Update Settings']");
	private By imgProfile = By.xpath("//img[@class='user-pic']");
	
	//2. Constructor of page class
	public PgSignUp(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page actions: features (behavior) of page in form of methods
	public String getSignUpPageTitle() {
		return driver.getTitle();
	}
	
	public boolean clickOnSignUpLink() {
		driver.findElement(lnkSignUp).click();
		return true;
	}
	public void enterUsername(String username) {
		driver.findElement(txtBxUserName).sendKeys(username);
	}
	
	public void enterEmail(String email) {
		driver.findElement(txtBxEmail).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txtBxPassword).sendKeys(password);
	}
	
	public boolean signInEnabled() {
		boolean buttonIsEnabled = driver.findElement(btnSignIn).isEnabled();
		return buttonIsEnabled;
	}
	
	public void clickOnSignInBtn() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Actions a = new Actions(driver);
	      a.moveToElement(driver.findElement(btnSignIn)).
	      doubleClick().
	      build().perform();
	}
	
	public boolean clickOnSignUpButton() {
		driver.findElement(btnSignIn).click();
		return true;
	}
	
	public boolean clickOnSettings() {
		driver.findElement(lnkSettings).click();
		return true;
	}
	
	public void enterProfileUrl(String url) {
		driver.findElement(txtBxProfPicUrl).sendKeys(url);
	}
	
	public boolean clickOnUpdateSettings() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Actions a = new Actions(driver);
	      a.moveToElement(driver.findElement(btnUpdateSettings)).
	      doubleClick().
	      build().perform();
	      Thread.sleep(2000);
	      return true;
	}
	
	public String verifyProfileUrl() {
		String currentProfUrlIs = driver.findElement(imgProfile).getAttribute("src");
		return currentProfUrlIs;
	}
	
	public void scrollToElement() {
		WebElement element = driver.findElement(btnUpdateSettings);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static String getAlphaNumericString(int n, String field)
    {
		if(field.equals("username")) {
		
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			StringBuilder sb = new StringBuilder(n);
			for (int i = 0; i < n; i++) {
	            int index = (int)(AlphaNumericString.length()* Math.random());
	            sb.append(AlphaNumericString
	                          .charAt(index));
	        }	  
	        return sb.toString();
	        
		}else if(field.equals("email")) {
			
			String AlphaNumericString = "abcdefghijklmnopqrstuvxyz"
                    + "0123456789";
			StringBuilder sb = new StringBuilder(n);
			  
	        for (int i = 0; i < n; i++) {
	            int index = (int)(AlphaNumericString.length()* Math.random());
	            sb.append(AlphaNumericString
	                          .charAt(index));
	        }	  
	        return sb.toString();
	        
		}else if(field.equals("password")) {
			
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "!@#$%^&*()"
                    + "abcdefghijklmnopqrstuvxyz";

			StringBuilder sb = new StringBuilder(n);

			for (int i = 0; i < n; i++) {
			int index = (int)(AlphaNumericString.length()* Math.random());
			sb.append(AlphaNumericString
					.charAt(index));
			}

			return sb.toString();
		}else {
			System.out.println(field + " field is incorrect.");
			return null;
		}
        
    }
}
