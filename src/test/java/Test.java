import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "feature/feature",
        glue = "stepDef",
        tags = "@all"
)
public class Test {
    public void run(){
    }
}
