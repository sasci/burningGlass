package sasci.io.selenium.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "json:cucumber.json"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:report/cucumber"
        }
        ,features = "src/test/resources"
        ,glue = "sasci.io.selenium.steps"
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true
        ,tags = "@frame"
)
public class RunCucumberTest {
}