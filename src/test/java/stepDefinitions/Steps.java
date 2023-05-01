package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"Drivers/chromedriver");
        driver = new ChromeDriver();
    }
    @Given("User launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        System.setProperty("web-driver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);

    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enter Username as {string} and Password as {string}")
    public void user_enter_username_as_and_password_as(String username, String password) {
        lp.setUsername(username);
        lp.setPassword(password);
    }

    @When("Clicks on login")
    public void clicks_on_login() {
        lp.ClickLogin();
    }

    @Then("User should be on URL {string}")
    public void user_should_be_on_url(String url) {
        if (driver.getPageSource().contains("Invalid Credentials")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(url, driver.getCurrentUrl());
        }
    }

    @When("User click on logout link")
    public void user_click_on_logout_link() {
        lp.ClickLogout();

    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
}
