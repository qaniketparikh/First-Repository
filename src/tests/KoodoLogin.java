package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import data.KoodoDataFile;
import pages.KoodoLoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class KoodoLogin {
	WebDriver driver;
	KoodoLoginPage kl = new KoodoLoginPage();
	KoodoDataFile df = new KoodoDataFile();
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  kl.OpenBrowser();
	  kl.OpenURL();
	    
	  }

  @AfterMethod
  public void afterMethod() {
	  kl.CloseBrowser();
	  
  }
  
  @Test
  public void EmailValidation() {
	  kl.EnterPassword(df.WrongPassword);
	  kl.ClickNext();
	  Assert.assertEquals(df.EmailValerr, kl.EmailValerr());
	}
  
  @Test
  public void PasswordValidation() {
	  kl.EnterEmail(df.CorrectEmail);
	  kl.ClickNext();
	  
	  Assert.assertEquals(df.PasswordvalErr, kl.PassValErr());
	}
  
  

}
