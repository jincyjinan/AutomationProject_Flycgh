package test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.Fh_Enquiry;
import utilities.Excelutilities;

public class FlyEnquiryTest extends Baseclass
{
	ExtentHtmlReporter rep;
	ExtentTest test;
	ExtentReports ext;
	@BeforeTest 
	public void fun_report()
	{
		rep=new ExtentHtmlReporter("./FlycghProject/pjtReport.html");
		rep.config().setDocumentTitle("FlyCreativeGlobalHolidays Report");
		rep.config().setReportName("Automation Project");
		rep.config().setTheme(Theme.STANDARD);
		ext=new ExtentReports();
		ext.attachReporter(rep);
		ext.setSystemInfo("Host", "Local host");
		ext.setSystemInfo("Os","Windows");
		ext.setSystemInfo("Tester Name","Jincymol M J");
	}
	@Test (priority = 1)
    public void tab_setup()
	{
		test=ext.createTest("Fcgh_Loctab");
	    Fh_Enquiry fh=new Fh_Enquiry(driver);
	    fh.tab_setting(3);
	}
	   
	@Test(priority = 2)
    public void enquiry_submit() throws IOException, InterruptedException
    {
		test=ext.createTest("Fcgh_Enquire");
	    Fh_Enquiry fh=new Fh_Enquiry(driver);
		   String xl="D:\\FlycghProject\\data_enquiry.xlsx";
		   String sheet="Sheet1";
		   int rc=Excelutilities.get_rowCount(xl, sheet);
		   System.out.println(rc);
		   for(int i=1;i<=rc;i++)
		   {
			    String fname= Excelutilities.getExcel(xl, sheet, i, 0);
				String phone=Excelutilities.getExcel(xl, sheet, i, 1);
				String email= Excelutilities.getExcel(xl, sheet, i, 2);
				String servic= Excelutilities.getExcel(xl, sheet, i, 3);
				String destin=Excelutilities.getExcel(xl, sheet, i, 4);
				String days= Excelutilities.getExcel(xl, sheet, i, 5);	
				String noPeople=Excelutilities.getExcel(xl, sheet, i, 6);
				
				String date= Excelutilities.getDateExcel(xl, sheet, i, 7);
				String msg= Excelutilities.getExcel(xl, sheet, i, 8);
					   
			    fh.enquiry_check(fname,phone,email,servic,destin,days,noPeople);
			    fh.enqCheck_date(date, msg);
			    
			    fh.take_screen(i);
		   }
	   }
	@AfterTest
	public void verify()
	{
		ext.flush();
		driver.quit();
	}
}
