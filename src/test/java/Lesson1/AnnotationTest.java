package Lesson1;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnnotationTest {
    private AnnotationTest() {
    }

    @BeforeAll
    public static void setup_1_time()
    {
        System.out.println("Run 1 time");
    }

    @BeforeEach
    public void setup_test()
    {
        System.out.println("setup_test");
    }

    @AfterEach
    public void end_test()
    {
        System.out.println("end_test");
    }

    @Test
    @Order(2)
    @Tag("sprint1")
    public void sprint_1()
    {
        System.out.println("sprint_1");
    }

    @Test
    @Order(1)
    @Tag("sprint2")
    @Tag("function")
    public void spirnt_2()
    {
        System.out.println("spirnt_2");
    }

    @Test
    @Order(3)
    @Tag("sprint3")
    @Tag("function")
    public void sprint_3()
    {
        System.out.println("sprint_3");
    }
}
