package sasci.io.selenium.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sasci.io.selenium.steps.Initialize;

import java.util.List;


public class BasePage {
    final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait longWait;
    protected WebDriverWait wait;



    public BasePage(){
        this.driver= Initialize.driver;
        this.longWait=new WebDriverWait(driver,30);
        this.wait=new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
        logger.info("BasePage constructor");
    }

    protected void switchFrame(WebElement frame){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    protected void switchFrame(String frame){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    protected void switchToDefaultFrame(){
        final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        if (iframes.size() <= 0) {
            return;
        }
        driver.switchTo().defaultContent();
    }

    protected BasePage goTo(String url){
        driver.get(url);
        return this;
    }

    protected String getCurrentUrl(){
        final String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    protected boolean verifyUrl(String url){
        return getCurrentUrl().equalsIgnoreCase(url);
    }

    protected boolean webElementContains(final WebElement element, final String text){
        waitUntilVisible(element);
        return element.getText().contains(text);
    }

    protected boolean verifyURLContains(String url) {
        return getCurrentUrl().contains(url);
    }

    protected BasePage click(WebElement element) {
        element.click();
        return this;
    }

    protected BasePage actionMove(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return this;
    }

    protected BasePage actionClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return this;
    }

    protected BasePage clickNTimes(WebElement element, int times) {
        for (int i = 0; i < times; i++) {
            click(element);
        }
        return this;
    }

    protected BasePage type(WebElement element, String text) {
        element.sendKeys(text);
        return this;
    }

    protected BasePage clear(WebElement element) {
        element.clear();
        return this;
    }

    protected BasePage selectFromDropdown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }

    protected BasePage selectValueFromRadioButtonList(List<WebElement> elements, String value) {
        for (WebElement el : elements) {
            if (el.getAttribute("value").equals(value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    protected BasePage waitUntilElementInListIsVisible(List<WebElement> elements) {
        for (WebElement el : elements) {
            waitUntilVisible(el);
            break;
        }
        return this;
    }

    protected BasePage waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    protected BasePage waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public boolean waitUntilURLContains(String text) {
       return wait.until(ExpectedConditions.urlContains(text));
    }
}
