package SeleniumModule3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.annotations.Listeners;


@Listeners(ITestListenerClass.class)

public class Assignment3 {

  WebDriver driver;

  @Test(groups= {"Login"})
  public void setup()
  {
	 System.setProperty("Webdriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://demoqa.com/");
	
  }
  
  @Test(groups= {"Smoke"})
  public void functionaltest()
  {
	  	JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(0,250)", "");
		
		By form_element = By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]/div/div[2]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(form_element));
		driver.findElement(form_element).click();
		
		By practiceform_element = By.xpath("//*[text()='Practice Form']");
		WebDriverWait webdriverwait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		webdriverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(practiceform_element));
		driver.findElement(practiceform_element).click();
  }
  
  @Test(groups= {"Regression"})
  public void regressiontest() throws InterruptedException, AWTException
  {
	    WebElement FirstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		WebElement LastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		WebElement Email = driver.findElement(By.xpath("//*[@id='userEmail']"));
		
		WebElement Mobile = driver.findElement(By.xpath("//*[@id='userNumber']"));
		WebElement DateWidget = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")); 
	

		Thread.sleep(1000);
		FirstName.sendKeys("Pathange");
		 
		Thread.sleep(1000);
		LastName.sendKeys("Gaurav");
		
		Thread.sleep(1000);
		Email.sendKeys("gaurav.pathangej@gmail.com");
	
		Thread.sleep(1000);
		Mobile.sendKeys("8919876100");

		Thread.sleep(1000);
		DateWidget.click();
		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		Thread.sleep(1000);
		month.selectByVisibleText("January");
		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		Thread.sleep(1000);
		year.selectByValue("2024");
		WebElement Date = driver.findElement(By.xpath("//div[@aria-label='month  2024-01']/div/div[@aria-label='Choose Sunday, December 31st, 2023']"));
		Thread.sleep(1000);
		Date.click();
  }
 
  	  @Test(groups= {"failed"})
      public void failuretestcase() throws InterruptedException, AWTException
      {
        WebElement RadioButton = driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div/input[@value='Male']"));
    	WebElement subjects = driver.findElement(By.xpath("//*[@id='subjectsContainer']/div/div[1]"));  
    	WebElement Hobbies = driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']"));
    	WebElement btn = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
    	
    	try {
			Thread.sleep(1000);
			RadioButton.click(); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    	Thread.sleep(1000);
		subjects.sendKeys("DemoQA");

		Thread.sleep(1000);
		Hobbies.click();
		
    	Thread.sleep(1000);
		btn.click();

		Robot robot = new Robot();
		StringSelection file = new StringSelection("C:\\Users\\Gaurav\\Desktop\\Photo\\Photo.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
  	
		Assert.assertTrue(false);
	  }
  }		
 	
