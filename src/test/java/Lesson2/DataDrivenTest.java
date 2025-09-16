package Lesson2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DataDrivenTest {
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "Xin chao"})
    public void sayHello(String msg)
    {
        System.out.println(msg);
    }

    @ParameterizedTest(name="Add({0},{1}={2})")
    @CsvSource({"1,1,2", "2,-1,1", "-1,-1,-2","-10,10,0"})
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
    public void validEmail(String email, boolean expected) {
        System.out.println(email + "-" + email);
    }

    static Stream<Arguments> emailProvider() {
        return Stream.of(Arguments.of("khanh.tx@live.com", true));
    }

}
