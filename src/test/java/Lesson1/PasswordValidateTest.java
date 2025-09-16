package Lesson1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidateTest {
    @Test
    public void should_return_false_for_password_has_below_6_character() throws Exception {
        //Arrange
        String password = "12345";
        boolean expected = false;

        //Act
        PasswordValidate validator = new PasswordValidate();
        boolean actual = validator.validate(password);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_password_missing_lower_case() throws Exception {
        //Arrange
        String password = "ABC123456@$";
        boolean expected = false;

        //Act
        PasswordValidate validator = new PasswordValidate();
        boolean actual = validator.validate(password);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_password_missing_upper_case() throws Exception {
        //Arrange
        String password = "abc123456@$";
        boolean expected = false;

        //Act
        PasswordValidate validator = new PasswordValidate();
        boolean actual = validator.validate(password);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_password_missing_number() throws Exception {
        //Arrange
        String password = "abcABCD@$";
        boolean expected = false;

        //Act
        PasswordValidate validator = new PasswordValidate();
        boolean actual = validator.validate(password);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_for_password_missing_special_character() throws Exception {
        //Arrange
        String password = "abcABCD123";
        boolean expected = false;

        //Act
        PasswordValidate validator = new PasswordValidate();
        boolean actual = validator.validate(password);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_true_for_valid_password() throws Exception {
        String password = "abcABC123!@";
        boolean expected = true;

        PasswordValidate validator = new PasswordValidate();
        boolean actual = validator.validate(password);

        //Assert
        assertEquals(expected, actual);
    }
}
