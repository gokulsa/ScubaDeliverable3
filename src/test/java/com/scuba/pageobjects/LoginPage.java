package com.scuba.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;

	//Locators
	By username = By.id("txtUsername");
	By password = By.name("txtPassword");
	By loginButton = By.xpath("//input[@name='Submit']");
	By Forgot_Your_Pass = By.xpath("//*[@id=\"forgotPasswordLink\"]/a");
	By myinfo = By.cssSelector("#menu_pim_viewMyDetails > b");
	By userAccount = By.xpath("//*[@id=\"welcome\"]");
	By Logout = By.linkText("Logout");
	
	//Constructor invoked at the time of object creation, pass driver chrome/firefox/safari..
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}


	//Automation Actions/methods
	//LOGGING IN AND NAVIGATING TO MY INFO TAB
	public void login(String name,String pass) throws InterruptedException
	{
		driver.findElement(username).sendKeys(name);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		Thread.sleep(2000);
		driver.findElement(myinfo).click();
	}
	//LOGOUT AND BROWSER QUIT
	public void logout() throws InterruptedException
	{
		driver.findElement(userAccount).click();
		Thread.sleep(2000);
		driver.findElement(Logout).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
