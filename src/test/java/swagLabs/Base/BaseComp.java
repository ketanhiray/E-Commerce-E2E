package swagLabs.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import swagLabs.PageObjects.CartPage;
import swagLabs.PageObjects.CheckoutPage;
import swagLabs.PageObjects.InventoryPage;
import swagLabs.PageObjects.LoginPage;
import swagLabs.Utility.ConfigReader;
import swagLabs.Utility.DriverManager;

public class BaseComp {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected InventoryPage inventoryPage;
	protected CartPage cartPage;
	protected CheckoutPage checkoutPage;

	@BeforeClass
	public void setUp() {
		driver = DriverManager.getDriver();
		driver.get(ConfigReader.get("baseUrl"));

		// Initialize Page Objects
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	@AfterClass
	public void tearDown() {
		// DriverManager.quitDriver();
	}
}
