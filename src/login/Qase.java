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

		public static WebDriver d;

		public static void main(String[] args) throws IOException, InterruptedException {
			

	System.setProperty("webdriver.chrome.driver", "/home/yogita/Downloads/chromedriver_linux64/chromedriver");
	System.setProperty("webdriver.gecko.driver", "/home/yogita/Downloads/geckodriver-v0.26.0-linux64/geckodriver");




	Properties Property= new Properties();

	FileInputStream objfile= new FileInputStream("/home/yogita/eclipse-workspace/login/src/configure.properties");

	Property.load(objfile);
	System.out.println(Property.getProperty("Location"));
	System.out.println(Property.getProperty("URL"));
	d =new FirefoxDriver();


	d.get(Property.getProperty("URL"));
	d.findElement(By.xpath("//a[@id='signin']")).click();

	d.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(Property.getProperty("Username"));
	Thread.sleep(1000);

	d.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(Property.getProperty("Password"));
	d.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();


	String title=d.getTitle();
	System.out.println(title);


		}
	}


