package support;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class DriverUtils {

    private static String os;

    public static void initDriver(){
        os = System.getProperty("os");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver_" + os);
        System.setProperty("selenide.browser", "Chrome");
    }

}
