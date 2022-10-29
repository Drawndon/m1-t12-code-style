import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {

        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundValue(pay, 2);
    }

    double calculateSimplePercent(double initialDepositSum, double yearRate, int depositPeriod) {

        return roundValue(initialDepositSum + initialDepositSum * yearRate * depositPeriod, 2);
    }

    double roundValue(double value, int places) {

        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void printResultDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double resultDeposit = 0;
        if (action == 1) {
            resultDeposit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            resultDeposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultDeposit);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.printResultDeposit();
    }
}
