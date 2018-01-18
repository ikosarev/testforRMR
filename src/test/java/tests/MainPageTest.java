package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ChessTest {

    private static MainPage mainPage;
    private static String os;
    private static String baseUrl = "https://lichess.org/";
    private WebDriver driver;

    @BeforeClass
    public static void before() {
        os = System.getProperty("os");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver_" + os);
        System.setProperty("selenide.browser", "Chrome");
        mainPage = open( baseUrl, MainPage.class);
    }

    @Test
    public void createGameWithComp() throws InterruptedException {
       mainPage.clickSignIn();
       mainPage
    }

    @Test
    public void sendMessageToSelf (){

    }

    @Test
    public void qaSearch (){

    }

    @Test
    public void kidModeEnable (){

    }

    @Test
    public void createGameAndResign (){

    }

    @Test
    public void swagStoreAddingToBasket (){

    }

    @Test
    public void searchUser (){

    }

    @AfterClass
    public static void after(){
        System.out.println("That's all for now");
    }
}
