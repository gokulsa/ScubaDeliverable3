package com.scuba.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalDetails 
{
  @Test
  public void f() throws InterruptedException 
  {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//PASSING THE DRIVER PARAMETER
		LoginPage Object = new LoginPage(driver);
		
		//LOGGING IN AND NAVIGATING TO MY INFO TAB
		Object.login("Admin", "admin123");
		
		//PERSONAL DETAILS UPDATE
		WebElement edit=driver.findElement(By.xpath("//input[@id='btnSave']"));
		edit.click();
		WebElement empid=driver.findElement(By.xpath("//*[@id=\"personal_txtEmployeeId\"]"));
		Thread.sleep(2000);
		empid.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		empid.sendKeys("6117456");
		Thread.sleep(2000);
		WebElement DLN = driver.findElement(By.id("personal_txtLicenNo"));
		DLN.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		DLN.sendKeys("123456");
		/*WebElement SSN = driver.findElement(By.id("personal_txtNICNo"));
		SSN.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		SSN.sendKeys("654321");*/
		WebElement Save = driver.findElement(By.id("btnSave"));
		Save.submit();
		Thread.sleep(200);
	
		//VERIFICATION FOR SAVING
		WebElement Savesuccess = driver.findElement(By.className("inner"));
		System.out.println("Is Successfully saved? "+Savesuccess.isDisplayed());
		
		//LOGOUT
		Object.logout();
  }
}
