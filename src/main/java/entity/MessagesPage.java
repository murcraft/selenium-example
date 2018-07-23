package entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage  extends Page {
	private final String URL = "https://e.mail.ru/messages/inbox/";

	private final By findTextPad = By.cssSelector("span.b-toolbar__btn__text.b-toolbar__btn__text_pad");

	public MessagesPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get(URL);
	}

	public ComposePage findMessage() {
		driver.findElement(findTextPad).click();
		return new ComposePage(driver);
	}

}
