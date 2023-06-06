package resources;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

//	@Parameters("browserName")
	@BeforeMethod()
//	public void initializeDriver(String browserName) throws IOException {
	public void initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = null;
		String browserName = "";

		fs = new FileInputStream("/Users/mourin/eclipse-workspace/TvoLearn/src/main/java/resources/data.properties");

		prop.load(fs);

		browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
		driver = null;
	}

	public void getScreenshot(String result) throws IOException {
		// Web Driver take the screenshot as a file and save in virtually in src
		// variable.
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// copy the file from src and put in your local machine with the name of failed
		// test class. Use FileUtils method in java to copy file from source to
		// destination/local as below.
		FileUtils.copyFile(srcFile, new File("/Users/mourin/eclipse-workspace/TvoLearn/screenshot/" + result + "screenshot.png"));
	}
}
