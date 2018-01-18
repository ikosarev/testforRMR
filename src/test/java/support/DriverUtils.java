package support;


public class Utils {

    private static String os;

    public static void initDriver(){
        os = System.getProperty("os");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver_" + os);
        System.setProperty("selenide.browser", "Chrome");
    }


}
