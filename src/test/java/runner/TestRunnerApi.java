package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin={"pretty",
                "html:target/cucumber-reports2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@GorestAPI",
        dryRun = false
)
public class TestRunnerApi {

}
