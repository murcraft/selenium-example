package by.htp.selenium.run;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutBySearch {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "chromedriver";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tut.by");
		Thread.sleep(300);
		WebElement element = driver.findElement(By.className("entry-anounce"));
		
		String text = element.getText();
		System.out.println("Главная новость: " + text);
	
		WebElement pageMainNews = driver.findElement(By.className("anounce__link"));
		pageMainNews.click();
		int count = 0;
		
		List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"article_body\"]/p[position()>1]"));

		for(WebElement el : results) {
			count++;
			String linkName = el.getText();
			System.out.println(linkName);
		}
		System.out.println("Количество параграфов: " + count);

	}

}
