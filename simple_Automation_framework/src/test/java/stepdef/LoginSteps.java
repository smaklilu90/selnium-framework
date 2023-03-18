package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class LoginSteps {

    private WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
       
        driver = new ChromeDriver();

        //implicit wait 20 seconds 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // navigate to login page
        driver.get("https://www.saucedemo.com");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        // enter username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        // click on login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("user should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {
        // assert that user is redirected to home page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

      
    }
    
    @When("user clicks Add to cart on the first Product")
    public void user_clicks_add_to_cart_on_the_first_product() {
        WebElement product = driver.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']"));
        
        product.click();
    }
    
    @Then("Shoping cart icon shows {int}")
    public void shoping_cart_icon_shows(Integer int1) {
        String cartIcon = driver.findElement(By.className("shopping_cart_link")).getText();
        
        assertEquals(cartIcon, "1");
    }
    
    @When("user clicks shoping cart and click checkout")
    public void user_clicks_shoping_cart_and_click_checkout() throws InterruptedException {
        WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
      
        
        cartIcon.click();
        Thread.sleep(2000);
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
        
    }
    @Then("checkout Form displays")
    public void checkout_form_displays() {
        String formTitle = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        
      if (!formTitle.contains("Checkout")) {
    	  Assert.fail();
      }
        
    }
    @When("user enters information, clicks continue")
    public void user_enters_information_clicks_continue() {
        WebElement Fname = driver.findElement(By.id("first-name"));
        WebElement lname = driver.findElement(By.id("last-name"));
        WebElement zip = driver.findElement(By.id("postal-code"));
        WebElement contnue= driver.findElement(By.id("continue"));
        
        Fname.sendKeys("Samuel");
        lname.sendKeys("Mike");
        zip.sendKeys("12340");
        contnue.click();
        
    }
    @When("clicks finish")
    public void clicks_finish() {
        WebElement finish = driver.findElement(By.id("finish"));
        finish.click();
        
    }
    @Then("A message that says -Thank you for your order- displays")
    public void a_message_that_says_thank_you_for_your_order_displays() {
        String message = driver.findElement(By.xpath("//*[@id=\'checkout_complete_container\']/h2")).getText().toLowerCase();
        
       if (!message.contains("thank you")) {
    	   Assert.fail();
       }
    }
}
