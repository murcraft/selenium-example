package by.htp.selenium.run;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MailRuSendLetter {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "chromedriver";

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
		
		
		/*
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement loginField = driver.findElement(By.id("login"));
		loginField.sendKeys("ogulichek");
		
		WebElement passField = driver.findElement(By.name("loginForm.password"));
		passField.sendKeys("Korneluk1966");
		
		driver.findElement(By.name("ok")).click();
		
		enterProfile(driver);
		fillingPersonalForm(driver);
		enterConfidential(driver);


	}
	
	public static void fillingPersonalForm(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"profile-personal-form\"]/div[2]/b")).click();
		
		driver.findElement(By.name("personalForm.name")).clear();
		driver.findElement(By.name("personalForm.name")).sendKeys("Helen");
		driver.findElement(By.name("personalForm.surname")).clear();
		driver.findElement(By.name("personalForm.surname")).sendKeys("Kyzniacova");
		driver.findElement(By.name("personalForm.birthyear")).clear();
		driver.findElement(By.name("personalForm.birthyear")).sendKeys("1991");
		driver.findElement(By.name("personalForm.site")).clear();
		driver.findElement(By.name("personalForm.site")).sendKeys("www.rw.by");
		driver.findElement(By.name("personalForm.company")).clear();
		driver.findElement(By.name("personalForm.company")).sendKeys("GRIC");
		
		Select select = new Select(driver.findElement(By.name("personalForm.countryId")));
		select.selectByVisibleText("Беларусь");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		select = new Select(driver.findElement(By.name("personalForm.cityId")));
		select.selectByVisibleText("Минск");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		select = new Select(driver.findElement(By.name("personalForm.zone")));
		select.selectByValue("Europe/Minsk");
		driver.findElement(By.name("personalForm.avatar")).sendKeys("/Users/Helen/Desktop/081_p.jpg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("personalForm.about")).sendKeys("I am studying Java, and love classic music");
		
		driver.findElement(By.name("personalForm.save"));
	}
	
	public static void enterProfile(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[1]/b/a")).click();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div[1]/div[2]/div/a")).click();
	}
	
	public static void enterConfidential(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"profile-privacy-form\"]/div[1]/b")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"profile-privacy-form\"]/div[2]/form/table/tbody/tr[4]/td[1]/label"));
		Thread.sleep(1000);

		element.click();

		Thread.sleep(1000);
		driver.findElement(By.name("personalForm.save"));
		Thread.sleep(1000);
		element.submit();
		*/
	}

}
