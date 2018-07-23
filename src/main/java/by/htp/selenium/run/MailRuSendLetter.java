package by.htp.selenium.run;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailRuSendLetter {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "../../../../Applications/chromedriver";
	
	private final String URL = "https://e.mail.ru/compose/?1506079150826";
	private final static By findAdress = By.cssSelector("textarea.js-input.compose__labels__input");
	private final By fraimeForText = By.xpath("//iframe[contains(@id,'composeEditor_ifr')]");
	private final static By message = By.id("tinymce");
	private static String text = "ogulikpurse@gmail.com";
	private String adress = "Hey! It's my homework! It is not easy to find needed iframe=))";
	private final By m = By.cssSelector("span.b-toolbar__btn__text");

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.ru/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement loginEl = driver.findElement(By.xpath(".//input[@id='mailbox:login']"));
		loginEl.clear();
		loginEl.sendKeys("tathtp");
		
		WebElement passEl = driver.findElement(By.xpath(".//input[@id='mailbox:password']"));
		passEl.clear();
		passEl.sendKeys("Klopik123");
		
		driver.findElement(By.xpath(".//input[@class='o-control']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement emailArea = driver.findElement(By.xpath("//div[@class='compose-head']/descendant::textarea[@tabindex='4']"));
		emailArea.clear();
		emailArea.sendKeys("ogulikpurse@gmail.com");
		driver.findElement(By.xpath("//div[@class='compose-head']/descendant::input[@class='b-input']")).sendKeys("sending email from WebSD");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'composeEditor_ifr')]"));
		driver.switchTo().frame(frame);
		WebElement elementMessageBody = driver.findElement(message);
		elementMessageBody.sendKeys("Hey! It's my home work! ))");
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#b-toolbar__right > div:nth-child(3) > div > div:nth-child(2) > div.b-toolbar__item.b-toolbar__item_.b-toolbar__item_false > div > span")).click();
	}

}
