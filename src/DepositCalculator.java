import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) {
        double totalAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundNumberDecimal(totalAmount, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
         return roundNumberDecimal(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundNumberDecimal(double value, int numberDecimal) {
       double ScaLe = Math.pow(10, numberDecimal);
       return Math.round(value * ScaLe) / ScaLe;
    }

    void printPercentCalculationResult() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outAmount = 0;

        if (action ==1) {
            outAmount = calculateSimplePercentFunction(amount, 0.06, period);
        }
        else if (action == 2) {
            outAmount = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().printPercentCalculationResult();
    }
}
