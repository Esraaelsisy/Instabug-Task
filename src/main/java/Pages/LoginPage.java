package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="developer_email")
	WebElement emailTxtBox;
	
	
	@FindBy(id="password")
	WebElement passwordTxtBox;
	
	
	@FindBy(css="button.c-button.c-button--info.c-button--block.c-button--xlarge.u-bottom-margin--1x")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign up")
	WebElement signUpLink;
	
	@FindBy(xpath="//form[@name='loginForm']//div[@class='callout alert small']/p")
	public WebElement alertmessageLabel;
	
	public void login(String email , String password) throws InterruptedException
	{
		emailTxtBox.sendKeys(email);
		passwordTxtBox.sendKeys(password);
		Thread.sleep(2000);
		loginBtn.click();
		System.out.println("New user is logged in with email : " + email 
				+" , password : "+password);
	}
	
	public void navigatetoSignUp()
	{
		signUpLink.click();
		System.out.println("SignUp Page is opened");
	}

}
