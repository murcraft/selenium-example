package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumExamples {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "chromedriver";//.exe Users/Helen/Desktop/Kuzniatsova/

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		WebElement element = driver.findElement(By.name("q")); //передаем локатор
		
		element.sendKeys("what is web driver");//поле  ввода инф
		element.submit();
		
		List<WebElement> results = driver.findElements(By.className("r"));
		
		for(WebElement el : results) {
			String tagName = el.getTagName();
//			System.out.println(tagName);
			String aTag = el.findElement(By.xpath("a")).getTagName();
//			System.out.println(aTag);
			WebElement a = el.findElement(By.xpath("a")); //мб NoSuchElementException
			String linkName = a.getText();
			System.out.println(linkName);
		}
		
//		element.sendKeys("Java"); // StaleElement  - ссылка на объект element - id в браузере браузер помнит id только при обращении к браузеру
//		element.clear();
		////*[@id="maincontent"]/div[3]/table/tbody/tr/th --> right click - copy - xPath - for needed element
		
		
		
		Thread.sleep(5000);
		driver.close();
	}

}
