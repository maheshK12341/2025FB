package BaseP1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseC
{
 public static WebDriver driver;
 public static   String browser="chrome";
 public static String Env="QA";
	
	public static void browser_select()
	{
		
		   switch(browser){
		     case "chrome":
		    	 WebDriverManager.chromedriver().setup();
				 driver= new ChromeDriver();
		     break;

		     case "IE":
		    	 WebDriverManager.iedriver().setup();
			 driver= new InternetExplorerDriver();  
		     break;	    
		     default:
		     System.out.println("Not in the browser");
		     break;
		 }
	}
	
	public static void Env_select()
	{
		 
		   switch(Env){
		     case "QA":
		    		driver.get("https://www.fb.com");
		     break;

		     case "UAT":
		    		driver.get("https://www.UATfb.com");
		     break; 
		     case "Preprd":
		    		driver.get("https://www.Preprdfb.com");
		     break;
		     default:
		     System.out.println("Env is not available");
		     break;
		 }
	}
	
	
	public static void application_launch()
	{
		browser_select();
		Env_select();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public static void application_close()
	{
		driver.close();
	}
	

}
