package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	private SignUpPage signupPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private WebDriverWait wait;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
		signupPage = new SignUpPage(driver);
		loginPage = new LoginPage(driver, this.port);
		//homePage = new HomePage(driver);
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}



	@Test
	public void testSignUpFail(){
		gotoPage("signup");
		signupPage.sendData();
		signupPage.submit();
		signupPage.sendData();
		signupPage.submit();
		System.out.println(signupPage.getFailMessage());
		Assertions.assertEquals("The user name is already in use. Please choose another user name", signupPage.getFailMessage());
	}

	@Test
	public void testSuccessLogin() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData("h1", "123456" , "hassan " , "jamila");
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("h1" , "123456");
		loginPage.submitLogin();

	}

	@Test
	public void testSuccessLoginAndCreateEditNote() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData("h1", "123456" , "hassan " , "jamila");
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("h1" , "123456");
		loginPage.submitLogin();
		homePage = new HomePage(driver);
		String title = "my title";
		homePage.createNote(title , "my description");
		Thread.sleep(1000);
	}

	@Test
	public void testSuccessLoginAndCreateDeleteNote() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData("h1", "123456" , "hassan " , "jamila");
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("h1" , "123456");
		loginPage.submitLogin();
		homePage = new HomePage(driver);
		String title = "my title";
		homePage.createDeleteNote(title , "my description");
		Thread.sleep(1000);
	}

	@Test
	public void testInserCred() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData("h1", "123456" , "hassan " , "jamila");
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("h1" , "123456");
		loginPage.submitLogin();
		homePage = new HomePage(driver);
		String url = "https://www.google.com";
		String userName = "Hassan";
		String password = "123456";
		homePage.selectCredTab();
		homePage.clickAddCredButton();
		Thread.sleep(1000);
		homePage.sendCredDataAndSubmit(url, userName, password);
		homePage.clickEditCredButton();
		String insertedURL =  homePage.getURL();
		Assertions.assertEquals(insertedURL, url);
	}

	@Test
	public void testEditCred() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData("h1", "123456" , "hassan " , "jamila");
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("h1" , "123456");
		loginPage.submitLogin();
		homePage = new HomePage(driver);
		String url = "https://www.google.com";
		String userName = "Hassan";
		String password = "123456";
		homePage.selectCredTab();
		homePage.clickAddCredButton();
		Thread.sleep(1000);
		homePage.sendCredDataAndSubmit(url, userName, password);
		homePage.clickEditCredButton();
		homePage.editCred();
		String editedUrl = homePage.getURL();
		Assertions.assertEquals(editedUrl , url+"1");
	}

	@Test
	public void testDeleteCred() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData("h1", "123456" , "hassan " , "jamila");
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("h1" , "123456");
		loginPage.submitLogin();
		homePage = new HomePage(driver);
		String url = "https://www.google.com";
		String userName = "Hassan";
		String password = "123456";
		homePage.selectCredTab();
		homePage.clickAddCredButton();
		Thread.sleep(1000);
		homePage.sendCredDataAndSubmit(url, userName, password);
		homePage.clickDeleteCred();
		Assertions.assertThrows(org.openqa.selenium.TimeoutException.class, ()->{
			homePage.checkIfEditCredButtonExist();
		});
		Thread.sleep(2000);

	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void canAccessHomePage() throws InterruptedException {
		gotoPage("signup");
		signupPage.sendData();
		signupPage.submit();
		gotoPage("login");
		loginPage.sendData("hassan1", "123456");
		loginPage.submitLoginAndVerify();

		Thread.sleep(1000);
		loginPage.doLogout();

		Assertions.assertThrows(NoSuchElementException.class, () -> {loginPage.verifyHome();});

	}


	public void gotoPage(String page){
		driver.get("http://localhost:" + this.port + "/" + page);
	}
}
