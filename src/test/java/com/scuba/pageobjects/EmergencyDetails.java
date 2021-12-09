package com.scuba.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmergencyDetails 
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
	  Object.login("Admin", "admin123"); //Emergency Contact Update
	  WebElement Econ = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a"));
	  Econ.click();
	  WebElement Addbtn = driver.findElement(By.xpath("//*[@id=\"btnAddContact\"]"));
	  Addbtn.click();
	  WebElement Name = driver.findElement(By.id("emgcontacts_name"));
	  Name.sendKeys("Selenium");
	  WebElement Relationship = driver.findElement(By.id("emgcontacts_relationship"));
	  Relationship.sendKeys("Maven");
	  WebElement Mobile = driver.findElement(By.name("emgcontacts[mobilePhone]"));
	  Mobile.sendKeys("5445554455");
	  WebElement WorkTel = driver.findElement(By.name("emgcontacts[workPhone]"));
	  WorkTel.sendKeys("255663");
	  WebElement Savebtn = driver.findElement(By.name("btnSaveEContact"));
	  Savebtn.click();
	  //Verification for saving
	  WebElement Savesuccess = driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr/td[3]"));
	  System.out.println("Is Successfully Saved? " + Savesuccess.isDisplayed());
	  //LOGOUT
	  Object.logout();
  }
}
