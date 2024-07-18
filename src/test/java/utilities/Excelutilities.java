package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities
{
	public static String getExcel(String xl,String sheet,int r,int c) throws IOException
	{
	  FileInputStream ob=new FileInputStream(xl);
	  XSSFWorkbook wb=new XSSFWorkbook(ob);
	  XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
	  if(cell.getCellType()==CellType.STRING)
	  {
		  return cell.getStringCellValue();
	  }
	  else
	  {
		  return cell.getRawValue();
	  }	
	}
	public static String getDateExcel(String xl,String sheet,int r,int c) throws IOException
	{
	  FileInputStream ob=new FileInputStream(xl);
	  XSSFWorkbook wb=new XSSFWorkbook(ob);
	  XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
	  if (cell.getCellType() == CellType.NUMERIC) 
	  {
          Date dateValue = cell.getDateCellValue();
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String formattedDate = dateFormat.format(dateValue);
          return formattedDate;
	  }
	  else
	  {
		  return cell.getRawValue();
	  }	
	}
	public static int get_rowCount(String xl,String sheet) throws IOException
	{
		FileInputStream ob=new FileInputStream(xl);
		XSSFWorkbook wb=new XSSFWorkbook(ob);
		int rc=wb.getSheet(sheet).getLastRowNum();
		return rc;	
	}


}
