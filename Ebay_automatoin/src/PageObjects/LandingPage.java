package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rupesh on 1/5/2018.
 */

public class LandingPage {
	
	
	 @CacheLookup
     @FindBy(id = "sign_in")
     public WebElement signInBtn;
	 
	 @CacheLookup
     @FindBy(id = "register")
     public WebElement registerBtn;

	 @CacheLookup
     @FindBy(id = "search")
     public WebElement searchFld;
}
