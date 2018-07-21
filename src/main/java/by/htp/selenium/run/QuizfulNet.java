package by.htp.selenium.run;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuizfulNet {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "chromedriver";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.quizful.net/test");
		
		driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[3]/a")).click();
		Thread.sleep(500);
		
		WebElement loginField = driver.findElement(By.id("login"));
		loginField.sendKeys("murcraft1991");
		
		WebElement passField = driver.findElement(By.name("registrationForm.password"));
		passField.sendKeys("Murcraft1991");
		
		WebElement repassField = driver.findElement(By.name("registrationForm.repassword"));
		repassField.sendKeys("Murcraft1991");
		
		WebElement emailField = driver.findElement(By.name("registrationForm.email"));
		emailField.sendKeys("ogulikpurse@gmail.com"); 
		
		driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[5]")).click();
		
		String capchaVal = JOptionPane.showInputDialog("Введите capcha  значение");
		driver.findElement(By.name("registrationForm.captcha")).sendKeys(capchaVal);
		
		driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[3]/form/p[2]/input[1]")).click();
		
		Thread.sleep(1000);
		String selectLinkOpenNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpenNewTab);

//		driver.close();

	}

}
