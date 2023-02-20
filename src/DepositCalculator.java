import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate/ 12), 12 * period);
        return getRandomNumber(pay,2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return getRandomNumber(amount + amount * yearRate * period, 2);
    }

    double getRandomNumber(double value, int places) {
           double scaLe = Math.pow(10, places);
           return Math.round(value * scaLe) / scaLe;
    }

    void calculateDepostResult() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double amountAfterPeriod = 0;
        if (action ==1) {
            amountAfterPeriod = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            amountAfterPeriod = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountAfterPeriod);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepostResult();
    }
}
