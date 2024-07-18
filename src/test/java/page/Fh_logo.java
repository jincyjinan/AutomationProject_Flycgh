package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fh_logo 
{
	WebDriver driver;
	By logo=By.xpath("/html/body/div[1]/section[2]/div/div/div/section[5]/div/div[1]/div/div/div/a/img");
	public Fh_logo(WebDriver d)
	{
		this.driver=d;
	}
	public boolean logo_status()
	{
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement log=wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
	   boolean result= log.isDisplayed();
	   return result;
	}
}
