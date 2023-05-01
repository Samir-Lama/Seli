package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(name = "username")
    WebElement username; //

    @FindBy(name = "password")
    WebElement passwd;

    @FindBy(xpath = "//input[@value='Login']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//input[@value='Logout']")
    @CacheLookup
    WebElement btnLogout;

    public void setUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        username.clear();
        username.sendKeys(password);
    }

    public void ClickLogin() {
        btnLogin.click();
    }

    public void ClickLogout() {
        btnLogout.click();
    }
}
