package page;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Fh_Enquiry
{
	WebDriver driver;
    By enqBtn=By.xpath("/html/body/div[1]/section[2]/div/div/div/section[5]/div/div[3]/div/div/div/div/a/span/span");
    By tabLoc=By.xpath("//*[@id=\"elementor-popup-modal-5367\"]/div/div[2]/div/section/div/div/div/div[2]/div/ul");
    By tabLink=By.tagName("a");
    By datesam=By.xpath("//*[@id='form-field-field_ec10af7']");

    By fullname=By.xpath("//*[@id='form-field-name']");
    By phoneno=By.xpath("//*[@id='form-field-field_ef4465c']");
    By email=By.xpath("//*[@id='form-field-email']");
    By reqService=By.xpath("//*[@id='form-field-field_f5ba15a']");
    By destination=By.xpath("//*[@id='form-field-field_04d8df8']");
    By dayno=By.xpath("//*[@id='form-field-field_b344e88']");
    By noofpeople=By.xpath("//*[@id='form-field-field_e68d28a']");
    By date=By.xpath("//*[@id='form-field-field_ec10af7']");
    By message=By.xpath("//*[@id='form-field-field_c0be3f9']");

    By month=By.xpath("//*[@class='flatpickr-month']/div[1]/span");
    By prvBtn=By.xpath("/html/body/div[8]/div[1]/span[1]");
    By nxtBtn=By.xpath("/html/body/div[8]/div[1]/span[2]");
    By day=By.xpath("");


    By sendbtn=By.xpath("//*[@id=\"elementor-popup-modal-7066\"]/div/div[2]/div/section/div/div/div/div[3]/div/form/div/div[14]/button/span/span[2]");

    public Fh_Enquiry(WebDriver d)
    {
	   this.driver=d;
    }

    public void tab_setting(int no) 
    {
	driver.findElement(enqBtn).click();
	WebElement tabid=driver.findElement(tabLoc);
	List<WebElement> tablinks=tabid.findElements(tabLink);
    WebElement linkClk= tablinks.get(no);
    linkClk.click();
    WebElement datePicker = driver.findElement(datesam);
    datePicker.clear();	
   }

   public void enquiry_check(String fname,String phno,String mailid,String reqServic,String desti,String day,String pepCount) throws InterruptedException
   {
	driver.findElement(fullname).clear();
	driver.findElement(fullname).sendKeys(fname);
	driver.findElement(phoneno).clear();
	driver.findElement(phoneno).sendKeys(phno);
	driver.findElement(email).clear();
	driver.findElement(email).sendKeys(mailid);
	
	Select sc=new Select(driver.findElement(reqService));
		sc.selectByVisibleText(reqServic);
		
	driver.findElement(destination).clear();
	driver.findElement(destination).sendKeys(desti);
	driver.findElement(dayno).clear();
	driver.findElement(dayno).sendKeys(day);
	driver.findElement(noofpeople).clear();
	driver.findElement(noofpeople).sendKeys(pepCount);
	driver.findElement(date).clear();
	driver.findElement(date).sendKeys("0000-00-00");
	
}
    public void enqCheck_date(String startDate,String msg) throws InterruptedException
    {
	
	     driver.findElement(message).clear();
	     driver.findElement(message).sendKeys(msg);
	     LocalDate ld=LocalDate.parse(startDate);
         int yr=ld.getYear();
         Month aa=ld.getMonth();
         int day1=ld.getDayOfMonth();
         String dayToFind=Integer.toString(day1);
         while(true)
         { 
	        Thread.sleep(2000);
            WebElement mon= driver.findElement(month); 
	        String month=mon.getText(); 
	        if(month.equalsIgnoreCase(aa.toString()))
	        {
		      System.out.println("Pass");
		      break;
	        }
	        else if( yr>=2024)
	        {
	    	  Thread.sleep(2000);
	          driver.findElement(nxtBtn).click();    	      
	        }
	        else if(yr<=2023)
	        {
	    	  Thread.sleep(1000);
	    	  driver.findElement(prvBtn).click();
	        }  
         }
	     String xpathExpression = "/html/body/div[8]/div[2]/div/div[2]/div/span[text()='"+ dayToFind +"']";                              
         WebElement dayElement = driver.findElement(By.xpath(xpathExpression));
         dayElement.click();
	   //driver.findElement(sendbtn).click();	
	
    }

    public void take_screen(int n) throws IOException 
    {
    	TakesScreenshot takeScrn=(TakesScreenshot)driver;
    	File src_screen=takeScrn.getScreenshotAs(OutputType.FILE);
    	File out_screen=new File("D:\\FlycghProject\\pjt_screen\\img"+n+".png");
        FileHandler.copy(src_screen, out_screen);		
	}

}
