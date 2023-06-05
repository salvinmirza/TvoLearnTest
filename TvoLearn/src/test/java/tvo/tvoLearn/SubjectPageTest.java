package tvo.tvoLearn;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.ElementaryGradeHomePage;
import pageObjects.HomePage;
import pageObjects.SubjectLandingPage;
import resources.Base;

public class SubjectPageTest extends Base{
	
	
	void navigateToMathPage() {
		
		HomePage homePage = new HomePage(driver);
		List<WebElement> navItems = homePage.getNavItems();
		navItems.get(0).click();
		
		ElementaryGradeHomePage elementaryGradeHomePageTest = new ElementaryGradeHomePage(driver);
		List<WebElement> elementaryGradeList = homePage.getElementaryGradeList();
		elementaryGradeList.get(1).click();
		elementaryGradeHomePageTest.getMathDiv().click();
	}
	
	@Test
	public void subjectTitleIsMathematics() {
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		String actualGradeTitle = subjectLandingPage.getSubjectTitle().getText();
		Assert.assertEquals(actualGradeTitle, "Mathematics");
	}
	
	
	//Resources for Learning Links Testing , Assuming not-found-header not displayed. Could have manage in one method and working with loop to pass/fail scenarios

	@Test
	public void resourcesForLearningLinkIsNotWorking(){
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		List<WebElement> resourceForLearningLinks = subjectLandingPage.getResourceForLearningLinks();
		resourceForLearningLinks.get(0).click();
		Assert.assertEquals(subjectLandingPage.getContentNotFoundHeader().getText(), "Uh oh. We can't seem to find the page you are looking for.");
	}
	
	@Test
	public void resourcesForLearningLinkIsWorking(){
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		List<WebElement> resourceForLearningLinks = subjectLandingPage.getResourceForLearningLinks();
		resourceForLearningLinks.get(1).click();
		Assert.assertFalse(subjectLandingPage.getContentNotFoundHeader().isDisplayed());

	}
	
	
	//Could have merge both doSubscribeWithCorrectEmailFormat, doSubscribeWithInvalidEmailFormat test sceanrios in one method
	
	@Test
	public void doSubscribeWithCorrectEmailFormat() throws InterruptedException {
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		subjectLandingPage.getEmail().sendKeys("aa@gmail.com");
		subjectLandingPage.getSubscribeBTN().click();
		
    	Thread.sleep(5000L);

		String actualSuccessMsg = subjectLandingPage.getSuccessMsg().getText();
		System.out.println("actualErrorMsg :: "+actualSuccessMsg);
		Assert.assertEquals(actualSuccessMsg, "Almost finished... We need to confirm your email address. To complete the subscription process, please click the link in the email we just sent you.");
		
	}
	
	@Test
	public void doSubscribeWithInvalidEmailFormat() throws InterruptedException {
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		subjectLandingPage.getEmail().sendKeys("aa.com");
		subjectLandingPage.getSubscribeBTN().click();
		
    	Thread.sleep(5000L);

		String actualSuccessMsg = subjectLandingPage.getSuccessMsg().getText();
		System.out.println("actualErrorMsg :: "+actualSuccessMsg);
		Assert.assertEquals(actualSuccessMsg, "");
		
	}
	
}
