package Lesson3.BankInterest;

public class StandardInterestStrategy extends InterestStrategy {
    @Override
    double calculateRate(int months) {
        if(months<6) return 0.03;
        else if(months<12) return 0.045;
        else return 0.06;
    }
}
