package swagLabs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{

	WebDriver driver;

	@FindBy(className = "title")
	private WebElement pageTitle;

	// add-to-cart-sauce-labs-backpack
	 @FindBy(css = ".inventory_item:first-child button")
	//@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement firstAddToCartBtn;

	@FindBy(className = "shopping_cart_badge")
	private WebElement cartBadge;

	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	public boolean isOnInventoryPage() {
		return pageTitle.getText().equals("Products");
	}

	public void addFirstProductToCart() {
		firstAddToCartBtn.click();
	}

	public String getCartBadgeCount() {
		return cartBadge.getText();
	}

	public void goToCart() {
		cartIcon.click();
	}

}
