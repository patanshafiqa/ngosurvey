package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties pr;
	
	
	public TestBase()  // constructor using class name 
	{
		try {
		pr=new Properties();
	
			FileInputStream fi= new FileInputStream("C:\\Users\\patan\\eclipse-workspace\\biodiversityweb\\src\\main\\java\\com\\qa\\config\\config.properties");
			pr.load(fi);
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void intialization()
	{
		String browser=pr.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\patan\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(pr.getProperty("url"));
		//driver.switchTo().alert().accept();
		//driver.findElement(By.xpath("//*[@id=\"modal-subscribe\"]/div/div/div[1]/button")).click();
		
		
	}
}


