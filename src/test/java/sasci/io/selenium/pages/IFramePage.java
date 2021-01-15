package sasci.io.selenium.pages;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static sasci.io.selenium.utils.ConfigurationUtils.getValue;

public class IFramePage extends BasePage {
    @FindBy(tagName = "iframe")
    public WebElement frame1;
    @FindBy(xpath ="//a[contains(text(),'Will Morris')]")
    public WebElement author;

    public IFramePage open(String baseUrl) {
        final String url = getValue(baseUrl);
        goTo(url);
        return this;
    }

    public IFramePage titleContains(String text){
        final boolean contains = driver.getTitle().contains(text);
        assertEquals(true,contains);
        return this;
    }

    public void switchTo(String text) throws InterruptedException {
        actionMove(frame1);
        switchFrame(frame1);
        Thread.sleep(3000);
    }

    public void switchToDefault(){
        switchToDefaultFrame();
    }

    public void searchAuthor(){
        author.click();
    }

    public void authorPageTitle(String currentUrl){
        final String url = getValue(currentUrl);
        final boolean isCurrentUrl = driver.getCurrentUrl().equals(url);
        assertEquals(true,isCurrentUrl);
    }

    public void returnBack(){
        driver.navigate().back();
    }



}
