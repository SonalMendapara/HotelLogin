package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	WebElement SignInLink;
	
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

//	driver.findElement(By.xpath("//button[@type='submit']"))
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;

//	driver.findElement(By.xpath("//div[contains(@class,'msg-error-icon')]"))
	@FindBy(xpath = "//div[@class='sica-form-cont']/div[1]")
	WebElement wrongEmailPasswordErrmsg;

//	driver.findElement(By.xpath("//small[@id='email-error']"))
	@FindBy(xpath = "//small[@id='email-error']")
	WebElement emptyEmailErrmsg;

//	driver.findElement(By.xpath("//small[@id='password-error']"))
	@FindBy(xpath = "//small[@id='password-error']")
	WebElement emptyPasswordErrmsg;

	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\Selenium_WorkSpace\\Practice_HotelLogin\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browserName");
		System.out.println(browser);

		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() throws InterruptedException {
		//driver.get("https://ca.hotels.com/profile/signin.html");
		driver.get("https://ca.hotels.com/?locale=en_CA&pos=HCOM_CA&siteid=300000002&rffrid=sem.hcom.CA.AMP.003.00.03.s.s.kwrd%3Ddevice.creative.15238131.218791.adposition.targetid.loc_physical_ms.loc_interest_ms.keyword.1661917633401000001.aw.ds&PSRC=_psrc&semcid=HCOM-CA.UB.ADMARKETPLACE.GT-device-EN.HOTEL&SEMDTL=a1218791.b115238131.g1targetid.l1.e1device.m1gclid.r1_expediakwid.c1_expediaadid.j1loc_physical_ms.k1loc_interest_ms.d1creative.h1matchtype.i1feeditemid.n1.o1.p1.q1.s1.t1.x1.f1.u1.v1.w1&mfadid=adm");
		SignInLink.click();
		Thread.sleep(2000);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();
		Thread.sleep(2000);
	}
	
	public String readWrongEmailAndPasswordErr() {
		String actualErr = wrongEmailPasswordErrmsg.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readEmptyEmail() {
		String actualErr = emptyEmailErrmsg.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readEmptyPassword() {
		String actualErr = emptyPasswordErrmsg.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
}
