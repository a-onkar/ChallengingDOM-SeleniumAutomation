package com.test.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChallengingDOM {
    WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver" , "D:\\SeleniumLabs\\Installers\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/challenging_dom");
	}
	

	
	@Test
	// Verify the application page title.
	
	public void assertTitle() {
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
	    Assert.assertEquals(title, "The Internet", "Title does not match"); // Syntax - (Actual, Expected, IfFailedMessage).
	}
	

	@Test
	// Verify if the name of the application - Challenging DOM is displayed on page.
	
	public void checkPage() {
		String logo = driver.findElement(By.xpath("//h3[contains(text(),'Challenging DOM')]")).getText();
		System.out.println("Page title: "+logo);
	}
	

	@Test
	// Verify if the description of Challenging DOM application is displayed on page.
	
	public void verifyChallegingDOMDescription() {

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'The hardest part')]")).isDisplayed());
        System.out.println("The description on DOM page is verified");
        
        String text;
        text = driver.findElement(By.xpath("//p[contains(text(),'The hardest part in automated web testing is findi')]")).getText();
        System.out.println(text);	
	}

	
	@Test
	// Display all values from table in tabular form.
	
	public void tableContent() {
		for (int i=1; i<11;i++){
			  for (int j=1; j<6;j++) {
			    String text = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+ "]")).getText();
			    System.out.print(" "+ text);
			   }
			  System.out.println("");
		    }
          }

	
	
	@Test
	// Verify the presence of 'Fork me on GitHub' logo.
	
	public void testForkMeLogo() {
		boolean logo = driver.findElement(By.xpath("//div[@class='row']//a//img")).isDisplayed();
		System.out.println("Fork me on GitHub logo displayed : "+logo);
		Assert.assertTrue(logo);
	}
	
	
	

     
	@Test
	
//	Identify dynamic locators of three buttons using dynamic xpath.
//	Verify if all three buttons are enabled.
	
	public void buttonEnabled() {
		
		boolean b1 = driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[1]")).isEnabled();
		System.out.println("Is first button displayed? - "+b1);
		
        String bs1 = driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[1]")).getText();
		System.out.println("Text on the first button displayed:"+bs1);
		
		
		boolean b2 = driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[2]")).isEnabled();
		System.out.println("Is second button displayed? - "+b2);
		
        String bs2 = driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[2]")).getText();
		System.out.println("Text on the second button displayed:"+bs2);
		
		
		boolean b3 = driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[3]")).isEnabled();
		System.out.println("Is third button displayed? - "+b3);
		
        String bs3 = driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[3]")).getText();
		System.out.println("Text on the third button displayed:"+bs3);
	}
	
	
	@Test
	// Verify clicking of three buttons using dynamic xpath.
	
	public void clickButton() {
		
		driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[1]")).click();
		System.out.println("First button was clicked");
		
		driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[2]")).click();
		System.out.println("Second button was clicked");
		
		driver.findElement(By.xpath("//*[@class='large-2 columns']/child::a[3]")).click();
		System.out.println("Third button was clicked");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
