import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "stepDef",
        tags = "@all"
)
public class Test extends AbstractTestNGCucumberTests
{
    public void run(){
    }
}
