package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import support.Constants;
import support.DriverUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

	@FindBy(css="a.signin")
	private SelenideElement signInBtn;

	@FindBy(css="div#now_playing a.mini_board")
	private SelenideElement miniBoard;

	@FindBy(xpath="//div[@class='tabs']//a[contains(.,'in play')]")
	private SelenideElement gamesInPlayTab;

	@FindBy(css="a[href='/setup/ai']")
	private SelenideElement createWithCompBtn;

	@FindBy(css="div.game_config")
	private SelenideElement gameConfigPopup;

	@FindBy(css="select#variant")
	private SelenideElement variantDropdown;

	@FindBy(css="select#timeMode")
	private SelenideElement timeModeDropdown;

	@FindBy(xpath="//group[@class='radio']//div")
	private ElementsCollection levelRadioBtnList;

	@FindBy(css="div#topmenu a[href='/']")
	private SelenideElement mainPageBtn;

	@FindBy(css="a#user_tag")
	private SelenideElement userMenu;

	@FindBy(css="a[href='/inbox']")
	private SelenideElement inboxBtn;

	@FindBy(css="form[action='/logout']")
	private SelenideElement logoutBtn;

	public void goToMainPage(){
	    open(Constants.mainPageUrl);
    }

	public void clickSignIn(){
		signInBtn.click();
	}

	public void createGameWithComp(String colorOfPlayer){
		createWithCompBtn.click();
		gameConfigPopup.shouldBe(Condition.visible);
		variantDropdown.selectOption("Standard");
		timeModeDropdown.selectOption("Real time");
		levelRadioBtnList.get(3).click();
		$("button." + colorOfPlayer).click();
	}

    public int getNumberOfGamesInPlay(){
        gamesInPlayTab.click();
        try{
            return $$("div#now_playing a.mini_board").size();
        }
	    catch (NoSuchElementException e){
            return 0;
        }
    }

    public void goToGamesInPlay(){
        gamesInPlayTab.click();
    }

    public void goToInboxPage(){
        userMenu.click();
        inboxBtn.click();
    }

    public void logout(){
        try {
                userMenu.click();
                logoutBtn.click();
            }
        catch (NoSuchElementException e){
            System.out.println("Already logged out");
        }
    }


    public void enterExistingGame() {
        miniBoard.click();
    }
}
