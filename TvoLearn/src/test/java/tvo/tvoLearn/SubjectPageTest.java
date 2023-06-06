package tvo.tvoLearn;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
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
	
	

	@Test
	public void resourcesForLearningLinksAreWorking() throws IOException{
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		List<WebElement> resourceForLearningLinks = subjectLandingPage.getResourceForLearningLinks();
		Iterator<WebElement> it = resourceForLearningLinks.iterator();
	
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		while(it.hasNext()){

			System.out.println(it.next());
			url = it.next().getAttribute("href");
	
			System.out.println(url);
	
			if(url == null || url.isEmpty()){
				System.out.println(url + " :: URL is either not configured for anchor tag or it is empty");
				continue;
				}
	
		
			huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			if(respCode >= 400){
				System.out.println(url+" :: is a broken link");
				Assert.assertTrue(false);
				}
			else{
				System.out.println(url+" :: is a valid link");
				Assert.assertTrue(true);
				}
		
					
		}
	}
		
	
	//Success message should appear on the screen
	@Test
	public void doSubscribeWithCorrectEmailFormat() throws InterruptedException {
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		subjectLandingPage.getEmail().sendKeys("arta@gmail.com");
		subjectLandingPage.getSubscribeBTN().click();
		
		String generalSuccessMsg = subjectLandingPage.getGeneralSuccessMsg().getText();
		Assert.assertEquals(generalSuccessMsg, "Almost finished... We need to confirm your email address. To complete the subscription process, please click the link in the email we just sent you.");
		
	}
	
	//Error message should appear on the screen
	@Test
	public void doSubscribeWithInvalidEmailFormat() throws InterruptedException {
		navigateToMathPage();
		SubjectLandingPage subjectLandingPage = new SubjectLandingPage(driver);
		subjectLandingPage.getEmail().sendKeys("aa.com");
		subjectLandingPage.getSubscribeBTN().click();
		String generalErrorMsg = subjectLandingPage.getGeneralErrorMsg().getText();
		Assert.assertEquals(generalErrorMsg, "Please enter a valid email address.");
		
	}
	
}
