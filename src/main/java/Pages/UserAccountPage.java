package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountPage extends PageBase {

	public UserAccountPage(WebDriver driver) {
		super(driver);
	}
//u-text-smal c-top-navbar-menu__profile-item-name
	@FindBy(css = "span.u-text-smal.c-top-navbar-menu__profile-item-name")
	public WebElement userInfoList;

	@FindBy(xpath = "//div[text()='Logout']")
	WebElement logoutLink;

	public void logout() throws InterruptedException {
		userInfoList.click();
		Thread.sleep(2000);
		logoutLink.click();
		System.out.println("User is logged out");

	}

}
