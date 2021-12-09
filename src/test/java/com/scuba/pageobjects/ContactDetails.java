package com.scuba.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactDetails 
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
	  Object.login("Admin", "admin123"); //Contact Details Update
	  WebElement ConDetl = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[2]/a"));
	  ConDetl.click();
	  WebElement edit = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
	  edit.click();
	  WebElement addr = driver.findElement(By.id("contact_street1"));
	  addr.sendKeys("vrb street");
	  WebElement Mobile = driver.findElement(By.id("contact_emp_mobile"));
	  Mobile.sendKeys("5421354213");
	  WebElement WorkEmail = driver.findElement(By.id("contact_emp_work_email"));
	  WorkEmail.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  WorkEmail.sendKeys("automate@orangehrm.com");
	  WebElement Save = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
	  Save.click();
	  Thread.sleep(300);
	  //Verification for saving
	  WebElement Savesuccess = driver.findElement(By.className("inner"));
	  System.out.println("Is Successfully saved? "+Savesuccess.isDisplayed());
	  //LOGOUT
	  Object.logout();
  }
}
