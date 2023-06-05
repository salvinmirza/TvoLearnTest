package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubjectLandingPage {
	public WebDriver driver;
	
		
	By subjectTitle = By.xpath("//*[@id='s-e235c8ce-c10f-42b3-b324-32da5f7e97f5']/div/h2");
	
	By resourceForLearningLinks = By.xpath("//*[@id='resources']");

	//Content not-found-header
	By contentNotFoundHeader = By.xpath("//*[@id='block-system-main']/div/div[1]/h1");
	
	By email = By.xpath("//*[@id='mce-EMAIL']");
	By subscribeBTN = By.xpath("//*[@id='mc-embedded-subscribe']");
	By successMsg = By.xpath("//*[@id='mce-success-response']");
	
	public SubjectLandingPage(WebDriver driver) {
		this.driver=driver;
	}	
	
	public WebElement getSubjectTitle() {
		return driver.findElement(subjectTitle);
	}
	
	public List<WebElement> getResourceForLearningLinks() {
		WebElement resourceForLearningLinkList =  driver.findElement(resourceForLearningLinks);
		List<WebElement> videoLinks = resourceForLearningLinkList.findElements(By.tagName("li"));
		return videoLinks;
	
	}
	
	public WebElement getContentNotFoundHeader() {
		return driver.findElement(contentNotFoundHeader);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getSubscribeBTN() {
		return driver.findElement(subscribeBTN);
	}
	
	public WebElement getSuccessMsg() {
		return driver.findElement(successMsg);
	}
}
