package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fh_buttons 
{
	WebDriver driver;
	By enq_btn=By.xpath("/html/body/div[1]/section[2]/div/div/div/section[5]/div/div[3]/div/div/div/div/a/span/span");
	By viewpkg_btn=By.xpath("/html/body/div[2]/section[7]/div/div/div/section/div/div[1]/div/div[2]/div/div/a/span/span");
	public Fh_buttons(WebDriver d)
	{
		this.driver=d;
	}
	
	public boolean enqbtn_check() 
	{
		String engtext=driver.findElement(enq_btn).getText();
		String chkEnq="Enquire";
		boolean result=engtext.equalsIgnoreCase(chkEnq);
		return result;
	}
	public boolean viewpkg_check() 
	{
		String vptext=driver.findElement(viewpkg_btn).getText();
		String chk_Vp="View packages";
		boolean result1= vptext.equalsIgnoreCase(chk_Vp);
		return result1;
	}
}
