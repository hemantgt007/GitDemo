package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//glabal.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAUrl");
		String browser_properties= prop.getProperty("browser");
		String Browser_mvn=System.getProperty("browser");
		
		//result= testCondition? value1: value2
		String browser=Browser_mvn!=null ? Browser_mvn : browser_properties;
		
		if(driver==null) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");//just to avoid selenium exception error also added dependency in pom
		
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
		
		driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
			driver=new FirefoxDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		}
		return driver;
		
	}

}
