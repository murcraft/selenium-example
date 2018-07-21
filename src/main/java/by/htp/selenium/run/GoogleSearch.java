package by.htp.selenium.run;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "chromedriver";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		WebElement element = driver.findElement(By.name("q")); //передаем локатор
		
		element.sendKeys("web driver 3 new features java 8 htp tat 9");//поле  ввода инф
		element.submit();
		Thread.sleep(5000);
		String title = driver.getTitle();
		
		if(title.toLowerCase().contains("java")) {
			System.out.println("title contains Java");
		}

		int count = 0;
		
		WebElement resSets = driver.findElement(By.id("resultStats"));
		String text = resSets.getText().replaceAll(" ", "");
		System.out.println(text);

		String regex = "([0-9?]*)[ A-Za-zА-Яа-я]*?\\(([0-9],[0-9]*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		String resReg = null;
		
		while(matcher.find()) {
			resReg = matcher.group(1);
		}
	
		System.out.println(resReg);
		System.out.println();
	
		
		while(true) {
			WebElement a1;
			try{
				a1 = driver.findElement(By.id("pnnext"));
			
			Thread.sleep(1000);
			List<WebElement> results = driver.findElements(By.className("r"));
			
			for(WebElement el : results) {
//				String tagName = el.getTagName();

				String aTag = el.findElement(By.xpath("a")).getTagName();
				count++;

				WebElement a = el.findElement(By.xpath("a")); //мб NoSuchElementException
				String linkName = a.getText();
				System.out.println(count + " " + linkName);
				Thread.sleep(500);
			}
			Thread.sleep(500);
			a1.click();
			Thread.sleep(2000);
			
			} catch (Exception e) {
				System.out.println("Not found such element");
				break;
			}
		}
		System.out.println(count);
		
		if(Integer.parseInt(resReg) == count) {
			System.out.println("Show all results");
		}
	

	
	}
	

}
