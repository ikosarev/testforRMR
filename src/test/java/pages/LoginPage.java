package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.Constants;

public class LoginPage {

	@FindBy(css="input#username")
	private WebElement userField;

    @FindBy(css="input#password")
    private WebElement passField;

    @FindBy(css="button.submit.button")
    private WebElement submitBtn;

    public void loginTestBot(){
        userField.sendKeys(Constants.botLogin);
        passField.sendKeys(Constants.botPass);
        submitBtn.click();
    }






}
