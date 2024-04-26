package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (threadLocalDriver.get() != null){
            return threadLocalDriver.get();
        }

        String browser = Config.getProperty("browser");

        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");

                // Use preferences to disable geolocation permission prompt
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 means Block
                options.setExperimentalOption("prefs", prefs);

                threadLocalDriver.set(new ChromeDriver(options));
                break;
            case "firefox":
                threadLocalDriver.set(new FirefoxDriver());
                break;
            case "safari":
                threadLocalDriver.set(new SafariDriver());
                break;
            default:
                threadLocalDriver.set(new ChromeDriver());
        }

        // these are implicit waits applied to the driver
        threadLocalDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        threadLocalDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        threadLocalDriver.get().manage().window().maximize();

        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        if (threadLocalDriver.get() != null){
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }

}
