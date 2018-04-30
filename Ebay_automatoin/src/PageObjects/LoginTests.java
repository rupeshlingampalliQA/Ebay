package PageObjects;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rupesh on 1/5/2018.
 */

public class LoginTests extends BaseSetup {

	LandingPage landingPage;
	LoginPage loginPage;
	
	
	String userName = "testUser1";
	String passWord = "testPwd1";
	
	@Test
    public void testLogin()
    {
		landingPage.signInBtn.isDisplayed();
        landingPage.signInBtn.click();
        loginPage.userNameFld.sendKeys(userName);
        loginPage.passwordFld.sendKeys(passWord);
        loginPage.loginBtn.isEnabled();
        loginPage.loginBtn.click();
        if (landingPage.signInBtn.isDisplayed()) {
        	System.out.println("login failed");
		}else{
			System.out.println("login pass");
		}

    }
	

}
