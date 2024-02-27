package stepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.base;

public class Hooks {
	public static WebDriver driver;
	public base b=new base();
	
	@Before
	public void setup() throws IOException {
		
		driver=new ChromeDriver();
    	
       	driver.get(b.getProperties().getProperty("appurl"));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public WebDriver browser(String br) {
		
		 WebDriver d=new ChromeDriver();

		switch(br) 
		{
		case "chrome": d=new ChromeDriver();
		                break;
		case "edge": d=new EdgeDriver();
		                 break;
		case "firefox":d=new FirefoxDriver();
		                 break;
		}
		
		return d;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
  public void scroll(WebElement ele) {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[1].scrollIntoView();", ele);
		
	} 
  
  public Properties getProperties() throws IOException {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		Properties p=new Properties();
		p.load(file);
		return p;
	}
}
