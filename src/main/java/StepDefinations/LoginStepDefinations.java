package StepDefinations;

import java.io.IOException;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Allpages.loginpage;
import GenericMethods.AllGenericMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinations extends loginpage
{
	AllGenericMethods GM= new AllGenericMethods();
@Given("user is on login page")
public  void User_is_in_loginPage() throws IOException
{
	
	application_launch();
	ExtentCucumberAdapter.addTestStepLog("Lanuched successfully");
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GM.TakeScreencapture());
	
}


@When("^user enters valid username\"([^\"]*)\"$")
public  void user_enters_valid_username(String Emailid) throws IOException
{
	EnterEmailID(Emailid);
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GM.TakeScreencapture());
	ExtentCucumberAdapter.addTestStepLog("Entered username successfully "+Emailid);
}
	

@And("^user enters valid password\"([^\"]*)\"$")
public  void user_enters_valid_password(String password) throws IOException
{
	EnterPassword(password);
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GM.TakeScreencapture());
	ExtentCucumberAdapter.addTestStepLog("Entered password successfully "+password);
}


@And("clicks on submit")
public  void User_is_in_click() throws IOException
{
	Sigin_login();
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GM.TakeScreencapture());
	ExtentCucumberAdapter.addTestStepLog("CLick is done successfully");
	GM.Checkbox_click("Football",checkbox);
}
}
