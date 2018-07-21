package by.htp.selenium.run;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class ITAcademy {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "chromedriver";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().fullscreen();//.maximize();
		Thread.sleep(2000);
		driver.get("https://www.it-academy.by");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/asside/div/div/div[2]/div[2]/ul/li[1]/a"));
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		List<WebElement> list = driver.findElements(By.className("list-item__category-header"));
		List<WebElement> subList = driver.findElements(By.className("list-subitem__page-link"));
		
		for(WebElement el : list) {
			Thread.sleep(500);
			String text = el.getText();
			System.out.println(" " + text);
		}
		
		for(WebElement subEl : subList) {
			Thread.sleep(500);
			String subText = subEl.getText();
			System.out.println("   " + subText);
		}
		
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/main/section[1]/section[1]/div/ul/li[10]/ul/li/a")).click();
		Thread.sleep(2000);
		
		List<WebElement> courseElements = driver.findElements(By.className("course-item-block"));
		
		for(WebElement elC : courseElements) {
			Thread.sleep(500);
			WebElement titleElem = elC.findElement(By.className("course-item-block__title"));
			System.out.println(titleElem.getText());
			
			WebElement timeElem = elC.findElement(By.className("course-item__title"));
			System.out.print( "" + timeElem.getText());
			
			WebElement dateElem = driver.findElement(By.className("course-item__date"));
			System.out.print( ", ближайшая дата: " + dateElem.getText());
			
			WebElement priceElem = driver.findElement(By.className("price"));
			System.out.println( ", цена: " + priceElem.getText());
		}
		
		driver.close();
	}

}
