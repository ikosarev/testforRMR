package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import pages.GamePage;
import pages.InboxPage;
import pages.LoginPage;
import pages.MainPage;
import support.Constants;
import support.DriverUtils;

import static com.codeborne.selenide.Selenide.page;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainPageTest {

    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static GamePage gamePage;
    private static InboxPage inboxPage;

    @BeforeClass
    public static void beforeClass() {
        DriverUtils.initDriver();
        mainPage = page(MainPage.class);
        loginPage = page(LoginPage.class);
        gamePage = page(GamePage.class);
        inboxPage = page(InboxPage.class);
    }

    @Before
    public void before(){
        mainPage.goToMainPage();
    }

    @Test
    public void createGameWithComp() {
        mainPage.createGameWithComp("random");
        assertTrue("URL hasn't changed",!WebDriverRunner.url().equals(Constants.mainPageUrl));
        assertTrue("Game hasn't started",gamePage.isGameActive());
    }

    @Test
    public void createGameWithCompBlackPlayer() {
        mainPage.createGameWithComp("black");
        assertTrue(!WebDriverRunner.url().equals(Constants.mainPageUrl));
        assertTrue("Game hasn't started",gamePage.isGameActive());
        assertTrue(gamePage.verifyPlayerColor("black"));
    }

    @Test
    public void enterCreatedGameFromGamesInPlay()  {
        mainPage.clickSignIn();
        loginPage.loginTestBot();
        mainPage.goToMainPage();
        mainPage.createGameWithComp("random");
        mainPage.goToMainPage();
        mainPage.goToGamesInPlay();
        mainPage.enterExistingGame();
        assertTrue("Game hasn't started",gamePage.isGameActive());
    }

    @Test
    public void abortCreatedGame()  {
        mainPage.createGameWithComp("random");
        gamePage.abortGame();
        assertTrue("Games was not aborted",gamePage.isGameAborted());
    }

    @Test
    public void rematchAbortedGame()  {
        mainPage.createGameWithComp("random");
        gamePage.abortGame();
        gamePage.rematchGame();
        assertTrue(gamePage.isGameActive());
    }

    @Test
    public void sendMessageToSelf (){
        mainPage.clickSignIn();
        loginPage.loginTestBot();
        mainPage.goToMainPage();
        mainPage.goToInboxPage();
        inboxPage.sendMessageToSelf();
        assertTrue("No messages found", inboxPage.isThereAMessage());
        inboxPage.deleteMessage();
        assertFalse("Messages was not deleted", inboxPage.isThereAMessage());
        mainPage.logout();
    }

    @Test
    public void createGameLoginCheck (){
        mainPage.clickSignIn();
        loginPage.loginTestBot();
        mainPage.goToMainPage();
        mainPage.createGameWithComp("random");
        mainPage.logout();
        mainPage.clickSignIn();
        loginPage.loginTestBot();
        assertTrue("There was no game in play",mainPage.getNumberOfGamesInPlay() > 0);
        mainPage.logout();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("That's all for now");
    }
}
