package steps;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PgSignUp;

public class SignUpPageSteps {
	
	private String SignUpPageTitle = "Conduit";
	private PgSignUp pgSignUp = new  PgSignUp(DriverFactory.getDriver());
	private String profUrl = "https://picsum.photos/200";

	@Given("User navigates to Conduit application")
	public void user_navigates_to_conduit_application() {
		DriverFactory.getDriver().get("https://react-redux.realworld.io/");
		String currentSignUptitle = pgSignUp.getSignUpPageTitle();
		Assert.assertEquals(currentSignUptitle, SignUpPageTitle);	
		boolean isClicked = pgSignUp.clickOnSignUpLink();
		Assert.assertTrue(isClicked);
	}

	@When("User Creates random User Profiles in sign up screen")
	public void user_creates_random_user_profiles_in_sign_up_screen() throws InterruptedException {
		pgSignUp.enterUsername(PgSignUp.getAlphaNumericString(6, "username"));
		String emailId = PgSignUp.getAlphaNumericString(6, "email");
		pgSignUp.enterEmail(emailId + "@gmail.com");
		pgSignUp.enterPassword(PgSignUp.getAlphaNumericString(8, "password"));
		Thread.sleep(2000);
		boolean isEleEnabled = pgSignUp.signInEnabled();
		Assert.assertTrue(isEleEnabled);
		pgSignUp.clickOnSignInBtn();
	}

	@Then("User Navigates to Settings screen")
	public void user_navigates_to_settings_screen() {
		pgSignUp.clickOnSignInBtn();
		boolean isClicked = pgSignUp.clickOnSettings();
		Assert.assertTrue(isClicked);  
	}

	@Then("User sets the user profile image url")
	public void user_sets_the_user_profile_image_url() throws InterruptedException {
		pgSignUp.enterProfileUrl(profUrl);
		pgSignUp.scrollToElement();
		boolean isUpdated = pgSignUp.clickOnUpdateSettings();
		Assert.assertTrue(isUpdated);	
	}
	
	@Then("user Validates profile image url in home page")
	public void user_validates_profile_image_url_in_home_page() {
		String currentProfUrlIs = pgSignUp.verifyProfileUrl();
		Assert.assertEquals(currentProfUrlIs, profUrl);
	}
}
