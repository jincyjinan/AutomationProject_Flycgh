package page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fh_links 
{
	WebDriver driver;
	By links=By.tagName("a");
	
	public Fh_links(WebDriver d)
	{
		this.driver=d;
	}
	
	public void link_check()
	{
		List<WebElement> link=driver.findElements(links);
		System.out.println("Links: "+link.size());
		for(WebElement li:link)
		{
			String ref=li.getAttribute("href");
		    System.out.println(ref);
		}
	}
	
	public void broknlink_check() throws IOException
	{
		int v=0,b=0;
		try 
		{
		 List<WebElement> link=driver.findElements(links);
		  for(WebElement li:link)
		  {
			  String links=li.getAttribute("href");
			  URL ur=new URL(links);
			  HttpURLConnection con = (HttpURLConnection) ur.openConnection();
			  con.setConnectTimeout(3000);
			  con.connect();
			  int respcode=con.getResponseCode();  
			    if (respcode>=400)
			    {
				  System.out.println("Broken link. "+con.getResponseCode());
				  b++;
			    }
			    else
			    {
				  System.out.println("Valid link. ");
				  v++;			  
			    }			    
		  }
		}
		catch(Exception ex)
		{
			System.out.println("exception");
		}
		System.out.println("Broken links: "+b+" and Valid links: "+v);
	}

}
