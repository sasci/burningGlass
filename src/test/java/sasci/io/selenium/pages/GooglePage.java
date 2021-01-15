package sasci.io.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GooglePage extends BasePage {
    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(name = "btnK")
    public List<WebElement> searchButton;

    public GooglePage open(String url){
        goTo(url);
        return this;
    }

    public void search(String text){
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOf(searchButton.get(0))).click();
    }

}
