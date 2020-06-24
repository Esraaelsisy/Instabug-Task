package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import Pages.UserAccountPage;

public class UserLoginbyEmailTest extends TestBase {
	HomePage homeObj;
	SignUpPage signUpObj;
	LoginPage loginObj;
	UserAccountPage userAccountObj;

	@DataProvider(name = "SignUpData")
	public Object[][] SignUpData() {
		return new Object[][] { { "esraa.elsisy+001@gmail.com", "Esraa", "123456789" } };
	}

	@Test(dataProvider = "SignUpData", priority = 1, alwaysRun = true)
	public void userCanLoginSuccessfully(String email, String name, String password) throws InterruptedException {
		// navigate to Login Page
		homeObj = new HomePage(driver);
		homeObj.openLoginPage();

		// First , we need to sign up to valid email
		// 1- click on sign up link
		loginObj = new LoginPage(driver);
		loginObj.navigatetoSignUp();

		// 2- signup with valid data
		signUpObj = new SignUpPage(driver);
		signUpObj.Signup(email, name, password);

		// 3- logout from the current account
		userAccountObj = new UserAccountPage(driver);
		userAccountObj.logout();

		// 4- login
		loginObj.login(email, password);
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://dashboard.instabug.com/welcome-to-instabug"));
		// Assert.assertTrue(userAccountObj.userInfoList.getText().equals(name));

		Thread.sleep(2000);
		userAccountObj = new UserAccountPage(driver);
		userAccountObj.logout();
	}

	@Test(priority = 2)
	public void userEntersNotMatchedCredentials() throws InterruptedException {
		// navigate to Login Page
		homeObj = new HomePage(driver);
		homeObj.openLoginPage();

		// sign in with not registered email before
		loginObj = new LoginPage(driver);
		loginObj.login("esraa.elsisy+05@gmail.com", "123456878");

		// Assert the alert "Your email and/or password are incorrect"
		System.out.println(loginObj.alertmessageLabel.getText());
		Assert.assertTrue(loginObj.alertmessageLabel.getText().contains("Your email and/or password are incorrect"));

	}

	@Test(priority = 3, dependsOnMethods = { "userCanLoginSuccessfully" }, dataProvider = "SignUpData")
	public void userEntersWrongPassword(String email, String name, String password) throws InterruptedException {
		// navigate to Login Page
		homeObj = new HomePage(driver);
		homeObj.openLoginPage();

		// sign in with not registered email before
		loginObj = new LoginPage(driver);
		loginObj.login(email, "wrongpassword8");

		// Assert the alert "Your email and/or password are incorrect"
		System.out.println(loginObj.alertmessageLabel.getText());
		Assert.assertTrue(loginObj.alertmessageLabel.getText().contains("Your email and/or password are incorrect"));
	}

}
