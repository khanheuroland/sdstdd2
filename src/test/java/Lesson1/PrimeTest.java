package Lesson1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeTest {
    @BeforeAll
    public static void setup_1_time()
    {
        System.out.println("Run 1 time from PrimeTest");
    }

    @Test /*Danh dau, day la method test*/
    public void should_return_true_for_prime_number_check() {
        //Gia thiet - Arrange
        int number = 3;
        boolean expected = true;

        //Thuc hien - Act
        PrimeNumber prime = new PrimeNumber();
        boolean actual = prime.check(number);

        //Kiem tra - Assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_not_prime_number_check() {
        //Arrange
        int number = 4;
        boolean expected = false;

        PrimeNumber prime = new PrimeNumber();
        boolean actual = prime.check(number);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_number_less_than_2() {
        //int number = 1//or 0
        int number = 1;
        boolean expected = false;
        PrimeNumber prime = new PrimeNumber();
        boolean actual = prime.check(number);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_negative_number()
    {
        //Arrange
        int number =-2;
        boolean expected = false;

        //Act
        PrimeNumber prime = new PrimeNumber();
        boolean actual = prime.check(number);

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    public void should_return_exception_for_null_input()
    {
        //Arrange
        Integer number =null;
        boolean expected = false;

        //Act
        PrimeNumber prime = new PrimeNumber();
        boolean actual = prime.check(number);

        //Assertion
        assertEquals(expected, actual);
    }

}

