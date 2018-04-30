package PageObjects;

import org.testng.annotations.Test;

/**
 * Created by Rupesh on 1/5/2018.
 */

public class SearchResultsTests extends BaseSetup {
	
	LandingPage landingPage;
	LoginTests loginTests;
	SearchResultsPage searchResult;
	
	String productIphone = "iPhone7";
	
	@Test
	public void searchAProduct(){
		loginTests.testLogin();
		landingPage.searchFld.isDisplayed();
		landingPage.searchFld.sendKeys(productIphone);
		searchResult.firstProduct.isDisplayed();
		searchResult.firstProduct.click();
		
	}
	
	@Test
	public void searchAProductAndPurchase(){
		searchAProduct();
		searchResult.buyNowBtn.isDisplayed();
		searchResult.buyNowBtn.click();
		searchResult.proceedToPayBtn.isDisplayed();
		searchResult.proceedToPayBtn.click();
	}
	
	

}
