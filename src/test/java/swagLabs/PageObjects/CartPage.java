package swagLabs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	WebDriver driver;

	@FindBy(className = "cart_item")
	private WebElement cartItem;

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public boolean isProductInCart() {
		return cartItem.isDisplayed();
	}

	public void clickCheckout() {
		checkoutBtn.click();
	}

}
