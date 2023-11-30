package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import com.qa.webpages.LoginPage;

public class LoginTest extends TestBase{
	static String sname ="shafi" ;
	LoginPage lp;
	TestUtil testUtil;
	public LoginTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		intialization();
		testUtil = new TestUtil();
		lp=new LoginPage(driver);
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title, "Biodiversity Survey");
	}
	@DataProvider
	public Object[][] getbioTestdata() throws Throwable, Throwable 
	{
		Object data[][]=TestUtil.getTestData(sname);
				//TestUtil.getTestData(sheetName); 

		//System.out.println(data);
		return data;
	}
 
	@Test(priority=2, dataProvider = "getbioTestdata")
	public void FLOlogin(String Username, String password)
	{
		lp.login(Username, password);
		System.out.println("hi shafi khan");
		//lp.login(pr.getProperty("username"), pr.getProperty("password"));
		//System.out.println("sucess");
	
	}
	@Test(enabled = false)
	public void crmLogoImageTest(){
		boolean flag = lp.validateApsbblogo();
		Assert.assertTrue(flag);
	}

	
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
}
