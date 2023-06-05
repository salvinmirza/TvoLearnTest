package tvo.tvoLearn;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

import java.util.List;

import org.openqa.selenium.WebElement;


public class HomePageTest extends Base{
	
	@Test
	public void titleLogoDisplayed() {

		HomePage homePage = new HomePage(driver);
		boolean logoPresent = homePage.getTitleLogo().isDisplayed();
		Assert.assertTrue(logoPresent);
	}
	
	@Test
	public void navBarHasElementarySection() {

		HomePage homePage = new HomePage(driver);
		List<WebElement> navItems = homePage.getNavItems();
		Assert.assertTrue(navItems.get(0).getText().contains("Elementary (K - 8)"));
		navItems.get(0).click();
	}
	
	@Test
	public void elementaryHasNineGradeSection() {

		HomePage homePage = new HomePage(driver);
		List<WebElement> navItems = homePage.getNavItems();
		navItems.get(0).click();
		
		List<WebElement> elementaryGradeList = homePage.getElementaryGradeList();
		int totalItem = elementaryGradeList.size();
		Assert.assertEquals(totalItem, 9);

	}
	
}
