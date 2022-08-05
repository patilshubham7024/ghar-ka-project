package com.example.demo;


import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DemoApplicationTests {

	@Autowired
	private WebDriver driver;
	
	String url = "https://accounts.google.com/signin";
	String url2 = "https://www.flipkart.com/";
	String webMailUrl = "https://webmail.testyantra.in/";
	Actions actions;
	Duration timeout=Duration.ofSeconds(10);

	@BeforeClass
	public void setUp() {
//		System.setProperty("webdriver.edge.driver", "D:\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//		driver = new EdgeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
		log.info("Setup done.");
	}
	
	@Test
	public void testUrl() {
		System.out.println("testing method!");
		driver.navigate().to(url);
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void testGoogle() throws InterruptedException {
		driver.navigate().to(url);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("patilshubham7024@gmail.com");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
				
		WebElement element = driver.findElement(By.className("M6CB1c rr4y5c"));
//
//		actions.moveToElement(element).getActiveKeyboard()..perform();
		
	}
	
	@Test
	public void testWebMail() {
		try {
			log.info("testWebMail method.");
		driver.navigate().to(webMailUrl);
		driver.findElement(By.id("user")).sendKeys("shubham.p@testyantra.in");
		driver.findElement(By.id("pass")).sendKeys("Shubham$%!3&%$%");
		driver.findElement(By.id("login_submit")).click();
//		driver.manage().timeouts().getImplicitWaitTimeout();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until((Function<? super WebDriver, ExpectedCondition<WebElement>>) ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[3]")));
		} catch (TimeoutException e) {
			log.error("Timed out.");
			Assert.fail("Timed out.");
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table/tbody/tr[3]")).click();

		} catch (Exception e) {
			Assert.fail();
			log.error("Something went wrong.");
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
