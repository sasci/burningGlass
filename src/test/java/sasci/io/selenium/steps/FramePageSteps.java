package sasci.io.selenium.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sasci.io.selenium.pages.IFramePage;

public class FramePageSteps {
    private IFramePage framePage=new IFramePage();

    @Given("user opens {string}")
    public void userOpens(String url) {
        framePage.open(url);
    }

    @When("user switch to frame {string}")
    public void userSwitchToFrame(String frame) throws InterruptedException {
        framePage.switchTo(frame);
    }

    @And("user see {string} in the title")
    public void userSeeInTheTitle(String arg0) {
        framePage.titleContains(arg0);
    }

    @And("user switch to default page")
    public void userSwitchToDefaultPage() {
        framePage.switchToDefault();
    }

    @And("user click author")
    public void userClickAuthor() {
        framePage.searchAuthor();
    }

    @Then("user should see in the {string}")
    public void userShouldSeeInThe(String arg0) {
        framePage.authorPageTitle(arg0);
    }

    @And("user returns previous page")
    public void userReturnsPreviousPage() {
        framePage.returnBack();
    }
}
