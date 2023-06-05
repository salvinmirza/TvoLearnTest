package tvo.tvoLearn;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ElementaryGradeHomePage;
import pageObjects.HomePage;
import resources.Base;

public class ElementaryGradeHomePageTest extends Base{
	
	@Test
	public void titleIncludesWordGrade() {

		ElementaryGradeHomePage elementaryGradeHomePageTest = new ElementaryGradeHomePage(driver);
		
		HomePage homePage = new HomePage(driver);
		List<WebElement> navItems = homePage.getNavItems();
		navItems.get(0).click();
		
		List<WebElement> elementaryGradeList = homePage.getElementaryGradeList();
		elementaryGradeList.get(1).click();
		
		Assert.assertTrue(elementaryGradeHomePageTest.getTitle().getText().contains("Grade"));

		
	}

}
