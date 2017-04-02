package by.nfed.testingtask.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailServerPage {

	private WebDriver driver;
	private final By emailElement = By.xpath("//*[@id=\"mailbox__login\"]");
	private final By passElement = By.id("mailbox__password");
	private final By submitElement = By.xpath("//*[@id=\"mailbox__auth__button\"]");

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public MailServerPage(WebDriver driver) {

		this.driver = driver;
	}

	public void openMailServerPage(String url) {

		getDriver().get("https://mail.ru");

	}

	public void enterMailBox(String login, String password) {

		WebElement loginField = getDriver().findElement(emailElement);
		loginField.sendKeys(login);

		WebElement passwordField = getDriver().findElement(passElement);
		passwordField.sendKeys(password);

		driver.findElement(submitElement).click();

	}

	public void openSentEmailPage(String sentLink) {

		driver.findElement(By.xpath(sentLink)).click();
	}

}
