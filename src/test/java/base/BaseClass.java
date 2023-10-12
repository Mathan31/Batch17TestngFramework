package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass{
	
	public static WebDriver driver; //545642121
	public String iBrowser = "Chrome";
	public String sURL = "https://uibank.uipath.com/";
	
	@BeforeClass
	public void invokeBrowser() {
		switch (iBrowser) {
		case "Chrome":
			System.out.println("User option is : "+iBrowser+",So invoking Chrome browser");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.out.println("User option is : "+iBrowser+",So invoking Firefox browser");
			driver = new FirefoxDriver();
			break;
		case "Edge":
			System.out.println("User option is : "+iBrowser+",So invoking Edge browser");
			driver = new EdgeDriver();
			break;
		case "IE":
			System.out.println("User option is : "+iBrowser+",So invoking IE browser");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("User option is wrong: "+iBrowser+",So invoking the default Chrome browser");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(sURL);

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}
