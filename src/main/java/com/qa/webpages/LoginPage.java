package com.qa.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="exampleInputEmail1")
	WebElement username;
	
	@FindBy(id="exampleInputPassword1")
	WebElement password;
	
	@FindBy (xpath="//button[text()='Submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement apsbblogo;
//Initializing the page objects
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


//Actions

public String validateLoginPageTitle(){
	return driver.getTitle();
}
public boolean validateApsbblogo(){
	return apsbblogo.isDisplayed();
}


 public void login(String uname,String pwd)
 {
	 username.sendKeys(uname);
	 password.sendKeys(pwd);
	 submitbtn.click();
	 
 }


}
