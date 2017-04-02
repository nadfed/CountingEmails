package by.nfed.testingtask.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.nfed.testingtask.selenium.pages.MailServerPage;
import by.nfed.testingtask.selenium.pages.SentEmailPage;

public class LaunchTest {
	

	private WebDriver driver;
	private String mailUrl = "https://mail.ru";
	private String mailBoxlogin = "task_test";
	private String mailBoxPassword = "trava888";
	private String sentEmailLink = ".//*[@id='b-nav_folders']/div/div[2]/a";
		

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:/Selenium/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void CountSentEmail() {

		MailServerPage mailPage = new MailServerPage(driver);
		SentEmailPage sentPage = new SentEmailPage(driver);

		int sentEmailAmount = 0;

		mailPage.openMailServerPage(mailUrl);
		mailPage.enterMailBox(mailBoxlogin, mailBoxPassword);
		mailPage.openSentEmailPage(sentEmailLink);

		sentEmailAmount = sentPage.countLetters();
		System.out.println("Количество отправленных писем - " + sentEmailAmount);
		
	}

	@AfterTest
	public void tearDown() {

	driver.close();

	}
}
