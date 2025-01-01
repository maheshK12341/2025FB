package GenericMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import BaseP1.BaseC;

public class AllGenericMethods extends BaseC
{

	public static void select_ByIndex(int index,WebElement dropdown)
	{
		Select obj= new Select(dropdown);
				obj.selectByIndex(index);
	}
	
	public static void JavaScript_ExecutorClick(WebElement Element )
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Element);
		
	}

	public static void select_ByIndex(String Value,WebElement dropdown)
	{
		Select obj= new Select(dropdown);
				obj.selectByValue(Value);
	}
	
	public static String TakeScreencapture() throws IOException
	{
		
		TakesScreenshot scrShot = (TakesScreenshot) BaseC.driver;

		File sourceFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		File destinationPath = new File("D://KPHP//"
				+ "ScreenCapture" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(sourceFile, destinationPath);
		
		return destinationPath.getAbsolutePath();		
		
	}	
	public static void JavaScript_ExecutorSendKeys(WebElement Element, String SendKeyText )
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+ SendKeyText +"';", Element);
		
	}
	public static void DropDrop(WebElement SourceWebElement, WebElement DestinationElement )
	{
		 Actions act=new Actions(driver);
		  act.dragAndDrop(SourceWebElement, DestinationElement).build().perform();	
		  
	}
	
	public static void Excel_ready(String path,String Sheetname,int col1,int col2) throws IOException
	{
		
		String emailid = "";
		String password = "";
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(Sheetname);
		int rows = sheet.getLastRowNum();

		for (int i = 1; i <= rows; i++) {

		XSSFRow row = sheet.getRow(i);

		emailid = row.getCell(col1).getStringCellValue();

		password = row.getCell(col2).getStringCellValue();

		System.out.println(emailid);

		System.out.println(password);

		fs.close();

		}

		}
	// 
	
	public static void Checkbox_click(String checkboxname, By element)
	{
		List<WebElement>allchecbox= driver.findElements(element);
		
		for(int i=0;i<=allchecbox.size()-1;i++)
		{
			if(checkboxname.equals(allchecbox.get(i).getDomProperty("value")))
			{
				allchecbox.get(i).click();
			}
		}
		
	}
	

	public static boolean Checkbox_Iselected(String checkboxname, By element)
	{
		boolean flag = false;
		List<WebElement>allchecbox= driver.findElements(element);
		
		for(int i=0;i<=allchecbox.size()-1;i++)
		{
			if(checkboxname.equals(allchecbox.get(i).getDomProperty("value")))
			{
				if(allchecbox.get(i).isSelected())
				{
					flag=true;				
				}
				else
				{	
					return flag;	
				}
				
			}
			break;
		}
		
		return flag;
	}
	
	
	
}
