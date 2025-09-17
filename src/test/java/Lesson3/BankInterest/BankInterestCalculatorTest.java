package Lesson3.BankInterest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BankInterestCalculatorTest {
    BankInterestCalculator cal =  new BankInterestCalculator();
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void should_calculate_interest_for_standard_customer_below_6_month(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.03*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.STANDARD);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {6,7,8,9,10,11})
    public void should_calculate_interest_for_standard_customer_has_month_from_6_to_12(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.045*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.STANDARD);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {12,13,24})
    public void should_calculate_interest_for_standard_customer_has_month_from_12(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.06*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.STANDARD);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void should_calculate_interest_for_premium_customer_below_6_month(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.05*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.PREMIUM);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {6,7,8,9,10,11})
    public void should_calculate_interest_for_premium_customer_has_month_from_6_to_12(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.065*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.PREMIUM);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {12,13,24})
    public void should_calculate_interest_for_premium_customer_has_month_from_12(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.08*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.PREMIUM);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void should_calculate_interest_for_vip_customer_below_6_month(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.07*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.VIP);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {6,7,8,9,10,11})
    public void should_calculate_interest_for_vip_customer_has_month_from_6_to_12(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.085*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.VIP);

        assertThat(interest, equalTo(expectedPricipal));
    }

    @ParameterizedTest
    @ValueSource(ints = {12,13,24})
    public void should_calculate_interest_for_vip_customer_has_month_from_12(int month){
        double pricipal = 1000000d;
        double expectedPricipal = pricipal*0.1*month/12;

        double interest =cal.calculateInterest(pricipal, month, BankInterestCalculator.AccountType.VIP);

        assertThat(interest, equalTo(expectedPricipal));
    }
    @Test
    public void Test_supper_Vip()
    {
        double pricipal = 1000000d;
        double expectedPricipal = 0;

        double interest =cal.calculateInterest(pricipal, 6, BankInterestCalculator.AccountType.SUPPER_VIP);

        assertThat(interest, equalTo(expectedPricipal));
    }

}
