package page;

import org.openqa.selenium.WebDriver;

public class Fh_Title 
{
	WebDriver driver;
	public Fh_Title(WebDriver d)
	{
		this.driver=d;
	}
	public boolean title_status()
	{
		String act_title=driver.getTitle();
		boolean result=act_title.equalsIgnoreCase("FlyCreative Global – Travel Agency Mumbai");
		return result;
	}


}
