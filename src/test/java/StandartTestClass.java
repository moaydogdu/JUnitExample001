import java.util.Random;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StandartTestClass {
    private static String oneInstancePerClass;
    private Integer oneInstancePerMethod;

    public StandartTestClass() {
    }

    @BeforeAll
    static void initAll() {
        oneInstancePerClass = String.valueOf((new Random()).nextInt());
        System.out.println("Init Before All Test Method");
    }

    @AfterAll
    static void tearDownAll() {
        oneInstancePerClass = null;
        System.out.println("Tear Down After All Test Method");
    }

    @BeforeEach
    void init() {
        this.oneInstancePerMethod = (new Random()).nextInt();
        System.out.println("Init Before Each Test Method");
    }

    @AfterEach
    void tearDown() {
        this.oneInstancePerMethod = null;
        System.out.println("Tear Down After Each Test Method");
    }

    @Test
    void testSomething1() {
        System.out.println("Test : testSomething1:" + this.oneInstancePerMethod + ":" + oneInstancePerClass);
    }

    @Test
    void testSomething2() {
        System.out.println("Test : testSomething2:" + this.oneInstancePerMethod + ":" + oneInstancePerClass);
    }

    @Test
    @Disabled("This test is not in scope for now")
    void testSomething3() {
        System.out.println("Test : testSomething3");
    }

    @Test
    void testSomething4() {
        Assertions.fail("A failing test...");
    }
}
