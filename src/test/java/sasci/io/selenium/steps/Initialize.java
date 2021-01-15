package sasci.io.selenium.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sasci.io.selenium.utils.ConfigurationUtils;

public class Initialize {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        new ConfigurationUtils().loadValues("/props/config.properties");
    }

    @After
    public void closeWebBrowser(){
        driver.close();
        driver.quit();
    }
}
