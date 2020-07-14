package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoodoLoginPage {
	WebDriver driver;
	
	@FindBy(id = "idtoken1")
	public static WebElement email;
	
	@FindBy(id = "idtoken2")
	public static WebElement password;
	
	@FindBy(className  = "loginGroup__loginButton")
	public static WebElement Next;
	
	@FindBy(id = "idtoken1_error-message")
	public static WebElement Emailvalerr;
	
	@FindBy(id = "idtoken2_error-message")
	public static WebElement Passvalerr;
		
	public void OpenBrowser() throws IOException  {
		FileInputStream fs = new FileInputStream("C:\\Practice\\Koodo.properties");
		  Properties prop = new Properties();
		  prop.load(fs);
		
		  
		  String browser = prop.getProperty("Browser");
		  
		  if(browser.equals("Firefox")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\jar\\geckodriver.exe");
			  driver = new FirefoxDriver();
		  }
		  else {
			  System.setProperty("webdriver.ie.driver", "C:\\jar\\IEDriverServer_x64_3.150.1\\IEDriverServer");
			  driver = new InternetExplorerDriver();
		  }
		  
		  PageFactory.initElements(driver , this);
	}
	
	public void OpenURL() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Practice\\Koodo.properties");
		  Properties prop = new Properties();
		  prop.load(fs);
		
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	
	public void EnterEmail(String a) {
		email.sendKeys(a);
		
	}
	
	public void EnterPassword(String b) {
		password.sendKeys(b);
	}
	
	public void ClickNext() {
		Next.click();
	}
	
	public String EmailValerr() {
		return Emailvalerr.getText();
	}
	
	public String PassValErr() {
		return Passvalerr.getText();
	}

}
