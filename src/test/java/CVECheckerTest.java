import com.example.CVEChecker;
import org.gradle.api.Project;
import org.gradle.internal.impldep.org.junit.Assert;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

public class CVECheckerTest {
    @Test
    public void greetingTest(){
        Project build = ProjectBuilder.builder().build();
        CVEChecker apply = build.getPlugins().apply(CVEChecker.class);
        apply.apply(build);
        Assert.assertTrue(build.getTasks().getNames().contains("checkCVEs"));
    }
}
