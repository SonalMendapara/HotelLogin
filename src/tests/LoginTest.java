package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
 
	LoginPage lp = new LoginPage();
	
	DataFile df = new DataFile();
	
	
  @BeforeMethod
  public void beforeMethod() throws IOException, InterruptedException {
	  lp.openBrowser();
	  lp.openPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }

  @Test (priority = 1)
  public void loginWithWrongEmailAndPassword() throws InterruptedException {
	  lp.login(df.wrongEmail, df.wrongPassword);
	  Assert.assertEquals(lp.readWrongEmailAndPasswordErr(), df.wrongEmailAndPasswordErr);
  }
  
  @Test (priority = 2)
  public void loginWithEmptyEmail() throws InterruptedException {
	  lp.login("", df.wrongPassword);
	  Assert.assertEquals(lp.readEmptyEmail(), df.emptyEmailErr);
  }
  
  @Test (priority = 3)
  public void loginWithEmptyPassword() throws InterruptedException {
	  lp.login(df.wrongEmail, "");
	  Assert.assertEquals(lp.readEmptyPassword(), df.emptyPasswordErr);
  }
 
}
