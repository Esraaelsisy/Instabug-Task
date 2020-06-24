package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBase {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "developer_email")
	WebElement emailTxtBox;

	@FindBy(id = "developer_name")
	WebElement nameTxtBox;

	@FindBy(id = "developer_password")
	WebElement passwordTxtBox;

	@FindBy(id = "CreateAccountSecondDesign")
	WebElement createAccountBtn;

	@FindBy(css = "a.o-link")
	WebElement loginLink;

	public void Signup(String email, String name, String password) {
		emailTxtBox.sendKeys(email);
		nameTxtBox.sendKeys(name);
		passwordTxtBox.sendKeys(password);
		createAccountBtn.click();

		System.out.println(
				"New user is signed up with email : " + email + " ,  name : " + name + " , password : " + password);

	}

	public void navigatetoLogin() {
		loginLink.click();
		System.out.println("Login Page is opened");
	}

}
