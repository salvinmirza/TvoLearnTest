package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;

	

	By titleLogo = By.xpath("//*[@id='shopify-section-header']/div/header/div/div[1]/div/a/img");
	By siteNavBar = By.xpath("//*[@id='SiteNav']");
	By elementaryGradeSection = By.xpath("//*[@id='SiteNavLabel-elementary-k-8']");
	

	public HomePage(WebDriver driver) {
		this.driver=driver;

	}	
	
	public WebElement getTitleLogo() {
		return driver.findElement(titleLogo);
	}
	
	public List<WebElement> getNavItems() {
		WebElement navBar =  driver.findElement(siteNavBar);
		List<WebElement> navItems = navBar.findElements(By.tagName("li"));
		return navItems;
	
	}
	
	public List<WebElement> getElementaryGradeList() {
		WebElement elementaryGrades =  driver.findElement(elementaryGradeSection);
		List<WebElement> elementaryGradeList = elementaryGrades.findElements(By.tagName("li"));
		return elementaryGradeList;
	
	}
	
	

}

