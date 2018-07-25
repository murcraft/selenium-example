package entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends Page{
	private final String URL = "http://mail.ru";

	private final By findLogin = By.id("mailbox__login");
	private final By findPassword = By.id("mailbox__password");
	private final By findLoginDomain = By.id("mailbox__login__domain");
	private final By findAuthButton = By.id("mailbox__auth__button");

	private final String login = "tathtp";
	private final String password = "Klopik123";
	private final By login__domain = By.id("mailbox__login__domain");

	private final String domen = "@inbox.ru";

	private WebElement elementLogin = null;
	private WebElement elementPassword = null;
	private WebElement elementLoginDomain = null;
	private WebElement elementAutButton = null;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	public void findMailboxLoginAndPassword() {
		elementLogin = driver.findElement(findLogin);
		elementPassword = driver.findElement(findPassword);
		elementLoginDomain = driver.findElement(findLoginDomain);
		elementAutButton = driver.findElement(findAuthButton);

	}

	public MessagesPage enterLoginAndPassword() {
		elementLogin.sendKeys(login);
		elementPassword.sendKeys(password);
		new Select(elementLoginDomain).selectByVisibleText(domen);
		elementAutButton.click();
		return new MessagesPage(driver);

	}

}
