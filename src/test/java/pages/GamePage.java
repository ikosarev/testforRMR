package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class GamePage {

    @FindBy(css="button.abort")
    private SelenideElement abortGameBtn;

    @FindBy(css="a.button.rematch")
    private SelenideElement rematchBtn;

    @FindBy(css="div.status")
    private SelenideElement gameStatus;

	@FindBy(css="div.cg-board")
	private SelenideElement gameBoard;

	@FindBy(css="div.username name")
	private SelenideElement compName;

	@FindBy(css="div.header")
	private SelenideElement statusInSetup;

    public boolean verifyPlayerColor(String expectedColor){
        try{
            return $("div.player." + expectedColor + " span.user_link").exists();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void abortGame(){
        abortGameBtn.click();
    }

    public void rematchGame(){
        rematchBtn.waitUntil(Condition.visible, 2000);
        rematchBtn.click();
        sleep(1000);
    }

    public boolean isGameAborted(){
        gameStatus.waitUntil(Condition.visible, 2000);
        return gameStatus.getText().contains("Game aborted");
    }

    public boolean isGameActive(){
        statusInSetup.waitUntil(Condition.visible, 2000);
        return statusInSetup.getText().contains("Playing right now");

    }

    public String getStatus(){
        return statusInSetup.getText();
    }



}
