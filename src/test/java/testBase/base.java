package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class base {
	
	public WebDriver driver;
	public static Properties p;
	public static String targetFilePath;
	public Logger log;
	
	
	
	@BeforeClass(groups= {"sanity"})
	@Parameters({"browser","os"})
   public void setup(String br,String os) throws IOException, InterruptedException{
		log=LogManager.getLogger(this.getClass());
       
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("provided os does not support....");
				return;
			}
           
			//browser
			switch(br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge"  :capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No matching browser....");return;
			       
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
	   else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local")) 
		{
		 //local execution 
			switch(br) 
			{
			case "chrome": driver=new ChromeDriver();
			                break;
			case "edge": driver=new EdgeDriver();
			                 break;
			default:System.out.println("No Matching Browser.... ");return;
			}
		}
		
		
		
			
		
       	driver.get(getProperties().getProperty("appurl"));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
	
	
	
	@AfterClass(groups= {"sanity"})
	public void tearDown() {
    	driver.quit();
    }
	
	public Properties getProperties() throws IOException {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		return p;
	}
	
	public void scroll(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
		
	}
	
	public String[] convert_String_to_Array(String s) {
		String[] arr=s.split("\n");
		
		return arr;
	}
	
	public void captureScreen(String name) throws IOException {
		
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name +  ".png";
		File targetFile=new File(targetFilePath);
		
		FileUtils.copyFile(sourceFile, targetFile);
	
		
	}
}
