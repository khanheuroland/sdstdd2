package Lesson3.BankInterest;

public class VipInterestStrategy extends InterestStrategy {
    @Override
    double calculateRate(int months) {
        if(months<6) return 0.07;
        else if(months<12) return 0.085;
        else return 0.1;
    }
}
