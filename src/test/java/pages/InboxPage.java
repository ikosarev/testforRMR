package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import support.Constants;

public class InboxPage {

	@FindBy(css="a.goto_compose")
	private SelenideElement composeBtn;

	@FindBy(css="input#username")
	private SelenideElement recipientField;

    @FindBy(css="input#subject")
    private SelenideElement subjectField;

    @FindBy(css="textarea")
    private SelenideElement textField;

	@FindBy(css="button.send")
	private SelenideElement sendBtn;

    @FindBy(css="a[href='/inbox']")
    private SelenideElement inboxBtn;

	@FindBy(css="tr.paginated_element")
	private SelenideElement messageEntry;

	@FindBy(css="button.delete")
	private SelenideElement deleteButton;


    public void sendMessageToSelf() {
        composeBtn.click();
        subjectField.sendKeys("Test subject");
        recipientField.sendKeys(Constants.botLogin);
        textField.sendKeys(Constants.testMessage);
        sendBtn.click();
    }

    public boolean isThereAMessage(){
        inboxBtn.click();
        try{
            return messageEntry.exists();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void deleteMessage(){
        messageEntry.click();
        deleteButton.click();
    }
}
