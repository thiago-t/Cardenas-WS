package funcionalTest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;


public class LoginSistemaComPageObjectTest {
	 
	 private WebDriver driver;
	 
	 @Before
	 public void before() {
		 System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/git/Buttonline-WS/src/main/resources/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 
	 @Test
	 public void loginComSucesso() {
		
		 LoginPage loginPage = new LoginPage(driver);
		   HomePage homePage = loginPage.
		                                visita("http://www.buttonline.com.br/data/mx_login.php").
		                                autentica("brian.roller@hotmail.com","123");
	 
	   assertTrue(homePage.isValida());
	 }
	 
	@After
	public void after() {
	   driver.quit();
	 }
	 
	}