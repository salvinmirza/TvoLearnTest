package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementaryGradeHomePage {
	
	public WebDriver driver;


	By title = By.xpath("//*[@id='s-9479b197-7240-460b-adbe-2dea7b60535e']/div/h1");
	By subjectMathDiv = By.xpath("//*[@id='s-f9924085-cdf6-409f-b476-67d7c5a74702']");

	
	public ElementaryGradeHomePage(WebDriver driver) {
		this.driver=driver;

	}	
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getMathDiv() {
		return driver.findElement(subjectMathDiv);
	}

}
