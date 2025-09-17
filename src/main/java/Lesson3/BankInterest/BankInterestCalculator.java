package Lesson3.BankInterest;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BankInterestCalculator {
    public enum AccountType
    {
        STANDARD, PREMIUM, VIP, SUPPER_VIP
    }

    private Map<AccountType, InterestStrategy> strategies = new EnumMap<>(AccountType.class);
    public BankInterestCalculator()
    {
        strategies.put(AccountType.STANDARD, new StandardInterestStrategy());
        strategies.put(AccountType.PREMIUM, new PremiumInterestStrategy());
        strategies.put(AccountType.VIP, new VipInterestStrategy());
        strategies.put(AccountType.SUPPER_VIP, new SupperVipInterestStrategy());
    }

    public double calculateInterest(double principal, int months, AccountType type) {
        if(principal<=0 ||months<=0) return 0;
        InterestStrategy strategy = strategies.get(type);
        if(strategy == null) throw new IllegalArgumentException("No strategy found for type " + type);
        double rate = strategy.calculateRate(months);
        return principal * rate*months/12;
    }
    /*
    // Tính lãi suất dựa vào số tiền gửi, kỳ hạn (tháng), loại sản phẩm
    public double calculateInterest(double principal, int months, String type) {
        double rate = 0.0;

        if (type.equals("standard")) {
            if (months < 6) {
                rate = 0.03;
            } else if (months < 12) {
                rate = 0.045;
            } else {
                rate = 0.06;
            }
        } else if (type.equals("premium")) {
            if (months < 6) {
                rate = 0.05;
            } else if (months < 12) {
                rate = 0.065;
            } else {
                rate = 0.08;
            }
        } else if (type.equals("vip")) {
            if (months < 6) {
                rate = 0.07;
            } else if (months < 12) {
                rate = 0.085;
            } else {
                rate = 0.1;
            }
        }

        return principal * rate * months / 12;
    }
     */
}