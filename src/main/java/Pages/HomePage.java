package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	public void openLoginPage()
	{
		loginLink.click();
		System.out.println("Login Page is opened");
	}

}
