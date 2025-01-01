package Allpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseP1.BaseC;
import GenericMethods.AllGenericMethods;

public class loginpage extends BaseC
{

public static By Emailid=By.id("email");
public static By Passwordid=By.xpath("//input[@id='pass']");
public static By Sigin=By.name("login");
public static By checkbox=By.xpath("//input[@type='checkbox']");

public static void EnterEmailID(String email)
{
	driver.findElement(Emailid).sendKeys(email);
}

public static void EnterPassword(String password)
{
	driver.findElement(Passwordid).sendKeys(password);
}

public static void Sigin_login()
{
	AllGenericMethods GM= new AllGenericMethods();
	WebElement Signlink= driver.findElement(Sigin);
	GM.JavaScript_ExecutorClick(Signlink);
//	GM.select_ByIndex("Credidit", Signlink);
	
}



}
