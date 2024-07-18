package test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass 
{
	WebDriver driver;
	@BeforeClass (alwaysRun = true)
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://flycreativeglobal.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
}
