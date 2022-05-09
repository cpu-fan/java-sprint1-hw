import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker(converter);

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("\nЗа какой месяц и день хотите внести данные по шагам?");
                System.out.print("Введите номер месяца (начиная с 0): ");
                int month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.print("Введите номер месяца в диапазоне от 0 до 11, где 0 - январь, а 11 - декабрь: ");
                    month = scanner.nextInt();
                }
                System.out.print("Введите день (начиная с 0): ");
                int day = scanner.nextInt();
                while (day < 0 || day > 29) {
                    System.out.print("Введите номер дня в диапазоне от 0 до 29, где 0 это 1 день месяца, а 29 - 30 день: ");
                    day = scanner.nextInt();
                }
                System.out.print("Введите количество пройденных шагов за этот день: ");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.print("Введите положительное число пройденных шагов: ");
                    steps = scanner.nextInt();
                }
                stepTracker.setStepsForDate(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("\nЗа какой месяц хотите вывести статистику?");
                System.out.print("Введите номер месяца (начиная с 0): ");
                int month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.print("Введите номер месяца в диапазоне от 0 до 11, где 0 - январь, а 11 - декабрь: ");
                    month = scanner.nextInt();
                }
                stepTracker.displayMonthlyStatistics(month);
            } else if (userInput == 3) {
                System.out.println("\nТекущая цель: " + stepTracker.dailyStepsGoal);
                System.out.print("Введите новую цель: ");
                int newDailyStepsGoal = scanner.nextInt();
                while (newDailyStepsGoal < 0) {
                    System.out.print("Введите положительное число: ");
                    newDailyStepsGoal = scanner.nextInt();
                }
                stepTracker.setDailyStepsGoal(newDailyStepsGoal);
            } else {
                System.out.println("Извините, команды \"" + userInput + "\" не существует. Пожалуйста, выберите из предложенного.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }

        System.out.println("\nПрограмма завершена. До встречи!");
    }

    public static void printMenu() {
        System.out.println("\nЧто хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Вывести статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выход.");
        System.out.print("Для выбора введите номер команды: ");
    }
}
