package Lesson2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DataDrivenTest {
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "Xin chao"})
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    public void sayHello(String msg)
    {
        System.out.println(msg);
    }

    @ParameterizedTest(name="Add({0},{1}={2})")
    @CsvSource({"1,1,2", "2,-1,1", "-1,-1,-2","-10,10,0"})
    @EnabledForJreRange(max = JRE.JAVA_18)
    public void Add(int f, int s, int total)
    {
        assertThat(f+s, equalTo(total));
    }

    @ParameterizedTest(name="Add({0},{1}={2})")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1, delimiter = ';')
    public void Add2(int f, int s, int total)
    {
        assertThat(f+s, equalTo(total));
    }

    @ParameterizedTest
    @MethodSource("emailProvider")
    @EnabledIf("checkCondition")
    public void validEmail(String email, boolean expected) {
        System.out.println(email + "-" + email);
    }

    static Stream<Arguments> emailProvider() {
        return Stream.of(Arguments.of("khanh.tx@live.com", true));
    }


    public static boolean checkCondition()
    {
        return false;
    }

    @Test
    public void Dont_write_many_assertion_in_a_test_method()
    {
        System.out.println("Assert 1");
        assertThat(true, equalTo(true));
        System.out.println("Assert 2");
        assertThat(true, equalTo(false ));
        System.out.println("Assert 3");
        assertThat(true, equalTo(true));
        System.out.println("Assert 4");
        assertThat(true, equalTo(true));
        System.out.println("Assert 5");
    }

    @Test
    public void smart_assert()
    {
        User person = User.builder().id(1).name("Khanh Tran").age(40).build();

        assertThat(person, allOf(
                hasProperty("id", equalTo(1)),
                hasProperty("name", equalTo("Khanh Tran")),
                hasProperty("age", equalTo(40))
        ));
    }

}
