package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubjectLandingPage {
	public WebDriver driver;
	
		
	By subjectTitle = By.xpath("//*[@id='s-e235c8ce-c10f-42b3-b324-32da5f7e97f5']/div/h2");
	
	By resourceForLearningLinks = By.xpath("//*[@class='resource_list']");

	
	By email = By.xpath("//*[@id='mce-EMAIL']");
	By subscribeBTN = By.xpath("//*[@id='mc-embedded-subscribe']");
	By generalErrorMsg =By.xpath("//div[contains(text(), 'Please enter a valid email address.')]");
	By generalSuccessMsg = By.xpath("//div[contains(text(), 'Almost finished... We need to confirm your email address. To complete the subscription process, please click the link in the email we just sent you.')]");

	
	public SubjectLandingPage(WebDriver driver) {
		this.driver=driver;
	}	
	
	public WebElement getSubjectTitle() {
		return driver.findElement(subjectTitle);
	}
	
	public List<WebElement> getResourceForLearningLinks() {
		WebElement resourceForLearningLinkList =  driver.findElement(resourceForLearningLinks);
		List<WebElement> videoLinks = resourceForLearningLinkList.findElements(By.tagName("a"));
		return videoLinks;
	
	}
	
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getSubscribeBTN() {
		return driver.findElement(subscribeBTN);
	}
	
	public WebElement getGeneralSuccessMsg() {
		return driver.findElement(generalSuccessMsg);
	}
	
	public WebElement getGeneralErrorMsg() {
		return driver.findElement(generalErrorMsg);
	}
}
