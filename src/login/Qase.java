package login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Qase {

		public static WebDriver driver;
		

		public static void main(String[] args) throws IOException, InterruptedException {
			

//	System.setProperty("webdriver.chrome.driver", "/home/yogita/Downloads/chromedriver_linux64/chromedriver");
	System.setProperty("webdriver.gecko.driver", "/home/yogita/Downloads/geckodriver-v0.26.0-linux64/geckodriver");


	Properties Property= new Properties();

	FileInputStream objfile= new FileInputStream("/home/yogita/eclipse-workspace/login/src/configure.properties");

	Property.load(objfile);
	System.out.println(Property.getProperty("Location"));
	System.out.println(Property.getProperty("URL"));
	driver =new FirefoxDriver();


	driver.get(Property.getProperty("URL"));
	driver.findElement(By.xpath("//a[@id='signin']")).click();

	driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(Property.getProperty("Username"));
	Thread.sleep(1000);

	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(Property.getProperty("Password"));
	driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();

	
	String actualtitle=driver.getTitle();
	String Expectedtitle="Qase | Projects";
	
	if(Expectedtitle.equals(actualtitle))
			{
		System.out.println("Pass");
		
			}
	else
	{
		System.out.println("Fail");
	}
	
	
		}
	}


