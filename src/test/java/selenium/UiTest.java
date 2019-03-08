package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UiTest {
	 WebDriver driver;

	    @BeforeClass
	    public static void setUpClass() {
	        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	    }

	    @Before
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("http://automationpractice.com/index.php");
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }
	    
	    @Test
	    public void testSearchWithData() {
	        WebElement searchForm = driver.findElement(By.id("search_query_top"));
	        searchForm.sendKeys("Shirt");
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	        WebElement searchButton = driver.findElement(By.name("submit_search"));
	        searchButton.click();
	        
	        List<WebElement> elementsFoundFromSearch = driver.findElements(By.className("product-container"));
	        Assert.assertEquals("Only 1 elements should be found.", 1, elementsFoundFromSearch.size());
	    }
	    
	    @Test
	    public void testSearchWithoutData() {
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	WebElement searchButton = driver.findElement(By.name("submit_search"));
	        searchButton.click();
	        
	        WebElement alertMessage = driver.findElement(By.className("alert-warning"));
	        
	        Assert.assertNotEquals("There should be an alertMessage.", null, alertMessage);
	    }
	    
	    @Test
	    public void testEmailValidationWhenRegistering() {
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement singInALink = driver.findElement(By.linkText("Sign in"));
	    	singInALink.click();
	        
	    	WebElement registrationEmailInput = driver.findElement(By.id("email_create"));
	    	registrationEmailInput.sendKeys("example@email");
	        
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement createAnAccountButton = driver.findElement(By.id("SubmitCreate"));
	    	createAnAccountButton.click();
	    	
	    	WebElement inputValidationError = driver.findElement(By.className("form-error"));
	    	Assert.assertNotEquals("There should be an Error indicator.", null, inputValidationError);

	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	registrationEmailInput.clear();

	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	registrationEmailInput.sendKeys("example@email.com");

	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	createAnAccountButton.click();
	    	
	    	WebElement inputValidationOk = driver.findElement(By.className("form-ok"));
	    	Assert.assertNotEquals("There should be an Ok indicator.", null, inputValidationOk);
	    }

	    @Test
	    public void testCursorWhenHoverOverBreadCrumb() {
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement singInALink = driver.findElement(By.linkText("Sign in"));
	    	singInALink.click();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        Actions hover = new Actions(driver);
	        WebElement breadCrumbElement = driver.findElement(By.className("icon-home"));
	        hover.moveToElement(breadCrumbElement).build().perform();

	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        Assert.assertEquals("The cursor should be a pointer.", "pointer", breadCrumbElement.getCssValue("cursor"));
	    }

	    @Test
	    public void testEnteringTextInQuantityInput() {
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement tShirtsALink = driver.findElement(By.linkText("T-SHIRTS"));
	    	tShirtsALink.click();
	    	
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement tShirtElement = driver.findElement(By.className("product_img_link"));
	    	tShirtElement.click();
	    	
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
	    	quantityInput.clear();
	    	quantityInput.sendKeys("test");
	    	
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	WebElement addToCartButton = driver.findElement(By.cssSelector("button.exclusive"));
	    	addToCartButton.click();
	    	
	    	WebElement error = driver.findElement(By.className("fancybox-error"));
	    	
	    	Assert.assertNotEquals("An error modal should appear.", null, error);
	    }

	    @After
	    public void after() throws InterruptedException {
	        Thread.sleep(2000);
	        driver.close();
	    }
}
