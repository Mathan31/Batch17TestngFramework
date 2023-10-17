package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class MenuPage extends BaseClass{
	
	public By oUILogo = By.xpath("//a[@class='navbar-brand']");
	
	public WebDriver driver;
	
	public MenuPage() {
	}

}
