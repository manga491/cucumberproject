package stepdefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Pageobjects.AddCustomerPageObject;
import Pageobjects.Loginpage;
import Pageobjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public Loginpage lp;
	public AddCustomerPageObject addCust;
	public SearchCustomerPage searchCustomer;
	
	
	//Created for generating random string for Unique email
		public static String randomestring() {
			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}
	
}
