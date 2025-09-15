package Lesson1;

public class PrimeNumber {
    public boolean check(int number) {
        if(number<2) return false;

        boolean isPrimeNumber = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }

        return isPrimeNumber;
    }
}
