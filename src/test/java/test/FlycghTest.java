package test;

import java.io.IOException;
import org.testng.annotations.Test;
import page.Fh_Title;
import page.Fh_buttons;
import page.Fh_links;
import page.Fh_logo;

public class FlycghTest extends Baseclass
{
	@Test (priority = 1)
	public void check_title()
	{
		Fh_Title fh=new Fh_Title(driver);
	    boolean status= fh.title_status();
	    if(status==true)
		{
			System.out.println("Title verified");
		}
		else
		{
			System.out.println("Title not match");
		}
		
	}
	@Test (priority = 2)
	public void check_logo()
	{
		Fh_logo fh=new Fh_logo(driver);
		boolean result=fh.logo_status();
		if(result==true)
		{
			System.out.println("Logo is Displayed");
		}
		else
		{
			System.out.println("Logo is not Displayed");		
		}	
	}
	@Test(priority = 3)
	public void check_links()
	{
		Fh_links fh=new Fh_links(driver);
		fh.link_check();
	}
	@Test (priority = 4)
	public void check_brokenlink() throws IOException
	{
		Fh_links fh=new Fh_links(driver);
		fh.broknlink_check();
	}
	@Test (priority = 5)
	public void check_buttons() 
	{
		Fh_buttons fh=new Fh_buttons(driver);
		boolean result1=fh.enqbtn_check();
		if(result1==true)
		{
			System.out.println("Enq.Button text Verified");
		}
		else
		{
			System.out.println("Enq.Button text mismatch");		
		}
		
		boolean result2=fh.viewpkg_check();
		if(result2==true)
		{
			System.out.println("Viewpkg.Button text Verified");
		}
		else
		{
			System.out.println("Viewpkg.Button text mismatch");		
		}	
	}
}
