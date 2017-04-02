package by.nfed.testingtask.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SentEmailPage {

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	private String sentLetterLocator = ".//*[@id='b-letters']/div/div[5]/div/div[2]/div[1]/following-sibling::*";
	private String firstSentLetterLocator = ".//*[@id='b-letters']/div/div[5]/div/div[2]/div[1]";

	public SentEmailPage(WebDriver driver) {

		this.driver = driver;
	}

	public int countLetters() {

		WebElement emptyBox = null;
		int lettersAmount = 0;
		emptyBox = driver.findElement(By.className("b-datalist__body"));

		if (emptyBox != null) {

			List<WebElement> list = driver.findElements(By.xpath(sentLetterLocator));
			List<WebElement> firstLetter = driver.findElements(By.xpath(firstSentLetterLocator));
			lettersAmount = list.size() + firstLetter.size();

		}

		try {
			emptyBox = driver.findElement(By.className("b-datalist__empty"));
			if (emptyBox != null) {
				lettersAmount = 0;
			}
		} catch (NoSuchElementException e) {

		}
		return lettersAmount;

	}

}
