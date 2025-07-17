package swagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import swagLabs.Base.BaseComp;
import swagLabs.Utility.ConfigReader;

public class AddToCartTest extends BaseComp {

	@Epic("Sauce Demo Automation")
	@Feature("E2E Checkout Flow")

	@Test(description = "Login with valid credentials")
	@Story("Test Case 1: Login")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest() {
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
		Assert.assertTrue(inventoryPage.isOnInventoryPage());
	}

	@Test(dependsOnMethods = "loginTest", description = "Add item to cart")
	@Story("Test Case 2: Add to Cart")
	@Severity(SeverityLevel.NORMAL)
	public void addToCartTest() {
		inventoryPage.addFirstProductToCart();
		Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1");
	}

	@Test(dependsOnMethods = "addToCartTest", description = "Cart Verification")
	@Story("Test Case 3: Cart Verification")
	public void cartPageTest() {
		inventoryPage.goToCart();
		Assert.assertTrue(cartPage.isProductInCart());
	}

	@Test(dependsOnMethods = "cartPageTest", description = "Enter personal details and verify overview page")
	@Story("Test Case 4: Checkout – Enter Personal Details")
	public void checkoutPersonalDetailsTest() {
		cartPage.clickCheckout();
		checkoutPage.enterDetails("John", "Doe", "12345");

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Not on checkout overview page.");
		Assert.assertTrue(checkoutPage.isProductDisplayedInOverview(), "Product not displayed in overview.");
	}

	@Test(dependsOnMethods = "checkoutPersonalDetailsTest", description = "Finish order and validate confirmation")
	@Story("Test Case 5: Finish the Order")
	public void finishOrderTest() {
		checkoutPage.clickFinish();
		Assert.assertTrue(checkoutPage.isThankYouMessageVisible(), "Thank-you message not found.");
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),
				"URL does not indicate order completion.");
	}

}
