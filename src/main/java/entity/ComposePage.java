package entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposePage extends Page {

	private final String URL = "https://e.mail.ru/compose/?1506079150826";
	private final By findAdress = By.cssSelector("textarea.js-input.compose__labels__input");
	private final By fraimeForText = By.xpath("//iframe[contains(@id,'composeEditor_ifr')]");
	private final By message = By.id("tinymce");
	private String text = "ogulikpurse@gmail.com";
	private String sendingMessasage = "Hey! It's my home work! ))";
	private final By sendButton = By.cssSelector("span.b-toolbar__btn__text");

	public ComposePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	public void findAdressFraimeSend() {
		driver.findElement(findAdress).sendKeys(text);
		WebElement frame = driver.findElement(fraimeForText);//By.xpath("//iframe[contains(@id,'composeEditor_ifr')]"));
		driver.switchTo().frame(frame);
		WebElement elementMessageBody = driver.findElement(message);
		elementMessageBody.sendKeys(sendingMessasage);//("Hey! It's my home work! ))");
		driver.switchTo().defaultContent();
		driver.findElement(sendButton);//(By.cssSelector("span.b-toolbar__btn__text")).click();
	}

}
