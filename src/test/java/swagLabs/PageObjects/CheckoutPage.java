package swagLabs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	WebDriver driver;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(id = "postal-code")
	private WebElement postalCode;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	@FindBy(css = ".inventory_item_name")
	private WebElement productNameOverview;

	@FindBy(className = "complete-header")
	private WebElement thankYouMessage;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void enterDetails(String fName, String lName, String zip) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(zip);
		continueBtn.click();
	}

	public void clickFinish() {
		finishBtn.click();
	}

	public boolean isProductDisplayedInOverview() {
		return productNameOverview.isDisplayed();
	}

	public boolean isThankYouMessageVisible() {
		return thankYouMessage.getText().contains("Thank you for your order!");
	}
}
