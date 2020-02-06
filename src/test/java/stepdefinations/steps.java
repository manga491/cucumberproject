package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pageobjects.AddCustomerPageObject;
import Pageobjects.Loginpage;
import Pageobjects.SearchCustomerPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class steps extends BaseClass {
	public WebDriver driver;
	public Loginpage loginpage;

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Venky\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		 loginpage=new Loginpage(driver);
		 
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	    loginpage.setUserName(email);
	    loginpage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		loginpage.clickLogin();
	}

	@SuppressWarnings("deprecation")
	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsucessful.")) {
	    driver.close();
	    Assert.assertTrue(false);
		}  else {	  	
	   
		Assert.assertEquals(title,driver.getTitle());
	}
	}
	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
	    loginpage.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	    
	}
	//Customer feature step definitions..........................................

	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
		addCust=new AddCustomerPageObject(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());    
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu()throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item()throws InterruptedException {
			Thread.sleep(2000);
		   addCust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		try {
			try {
				addCust.clickOnAddnew();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
	Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
			}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' or 'Registered' customer role
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("7/05/1985"); // Format: D/MM/YYY
		addCust.setCompanyName("busyQA");
		try {
			addCust.setAdminContent("This is for testing.........");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
	addCust.clickOnSave();
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}
	

	//steps for searching a customer using Email ID.........
	
@When("Enter customer EMail")
public void enter_customer_EMail() {
	searchCustomer=new SearchCustomerPage(driver);
	searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
}

@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
	searchCustomer.clickSearch();
	Thread.sleep(3000);
}

@Then("User should found Email in the Search table")
public void user_should_found_Email_in_the_Search_table() {
	boolean status=searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
   	Assert.assertEquals(true, status);
}
   	

//steps for searching a customer by using First Name & Lastname
   	@When("Enter customer FirstName")
   	public void enter_customer_FirstName() {
   		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setFirstName("Victoria");
   	}

   	@When("Enter customer LastName")
   	public void enter_customer_LastName() {
   		searchCustomer.setLastName("Terces");
   	}

   	@Then("User should found Name in the Search table")
   	public void user_should_found_Name_in_the_Search_table() {
   		boolean status=searchCustomer.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}
   	


   	
   	
   	
   	
}

	
	

