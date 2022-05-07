import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    Converter converter;
    int dailyStepsGoal;
    MonthData[] monthToData;

    public StepTracker(Scanner scanner, Converter converter) {
        this.scanner = scanner;
        this.converter = converter;
        dailyStepsGoal = 10000;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Запись шагов за определенную дату
    public void setStepsForDate() {
        System.out.println("\nЗа какой месяц и день хотите внести данные по шагам?");
        System.out.print("Введите номер месяца (начиная с 0): ");
        int month = scanner.nextInt();
        System.out.print("Введите день (начиная с 0): ");
        int day = scanner.nextInt();
        System.out.print("Введите количество пройденных шагов за этот день: ");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.print("Введите положительное число пройденных шагов: ");
            steps = scanner.nextInt();
        }
        monthToData[month].days[day] = steps;
    }

    // Вывод общей статистики за месяц
    public void displayMonthlyStatistics() {
        System.out.println("\nЗа какой месяц хотите вывести статистику?");
        System.out.print("Введите номер месяца (начиная с 0): ");
        int month = scanner.nextInt();

        System.out.println("\nКоличество пройденных шагов по дням:");
        stepsPerDay(month);
        System.out.println("Общее количество шагов за месяц: " + totalStepsPerMonth(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsPerMonth(month));
        System.out.println("Среднее количество шагов: " + totalStepsPerMonth(month) / monthToData[month].days.length);
        System.out.println("Пройденная дистанция (в км): " + String.format("%.2f", converter.distanceInKm(totalStepsPerMonth(month))));
        System.out.println("Количество сожжённых килокалорий: " + String.format("%.2f", converter.kCal(totalStepsPerMonth(month))));
        System.out.println("Лучшая серия: " + theBestSeries(month));
    }

    // Вывод количества шагов по дням за определенном месяц
    public void stepsPerDay(int month) {
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (i == monthToData[month].days.length - 1) {
                System.out.println((i + 1) + " день: " + monthToData[month].days[i]);
                break;
            }
            System.out.print((i + 1) + " день: " + monthToData[month].days[i] + ", ");
        }
    }

    // Общее количество шагов пройденных за месяц
    public int totalStepsPerMonth(int month) {
        int sumStepsForMonth = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            sumStepsForMonth = sumStepsForMonth + monthToData[month].days[i];
        }
        return sumStepsForMonth;
    }

    // Максимальное пройденное количество шагов в месяце
    public int maxStepsPerMonth(int month) {
        int maxStepsForMonth = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] > maxStepsForMonth) {
                maxStepsForMonth = monthToData[month].days[i];
            }
        }
        return maxStepsForMonth;
    }

    // Лучшая серия шагов в месяце
    public int theBestSeries(int month) {
        int count = 0;
        int bestSeries = 0;
        int[] bestSeriesArr = new int[30];
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] >= dailyStepsGoal) {
                count++;
            } else {
                count = 0;
            }
            bestSeriesArr[i] = count;
        }
        for (int i = 0; i < bestSeriesArr.length; i++) {
            if (bestSeriesArr[i] > bestSeries) {
                bestSeries = bestSeriesArr[i];
            }
        }
        return bestSeries;
    }

    // Изменение цели по количеству шагов в день
    public void setDailyStepsGoal() {
        System.out.println("\nТекущая цель: " + dailyStepsGoal);
        System.out.print("Введите новую цель: ");
        dailyStepsGoal = scanner.nextInt();
        while (dailyStepsGoal < 0) {
            System.out.print("Введите положительное число: ");
            dailyStepsGoal = scanner.nextInt();
        }
        System.out.println("Цель по количеству шагов в день: " + dailyStepsGoal);
    }

    class MonthData {
        int[] days;
        public MonthData() {
            days = new int[30];
        }
    }
}
