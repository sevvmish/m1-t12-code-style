import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double rate, int period) {
        double pay = amount * Math.pow((1 + rate / 12), 12 * period);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double rate, int period) {
        return round(amount + amount * rate * period, 2);
    }

    double round(double value, int precision) {
        double scale = Math.pow(10, precision);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int amount;
        int period;
        int depositType;
        double resultAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            resultAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
