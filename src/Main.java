import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker(scanner, converter);

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                stepTracker.setStepsForDate();
            } else if (userInput == 2) {
                stepTracker.displayMonthlyStatistics();
            } else if (userInput == 3) {
                stepTracker.setDailyStepsGoal();
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
