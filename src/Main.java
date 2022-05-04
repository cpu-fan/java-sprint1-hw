import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("<здесь будет обработка введенного количетва шагов>");
            } else if (userInput == 2) {
                System.out.println("<здесь будет вывод статистики>");
            } else if (userInput == 3) {
                System.out.println("Текущая цель: " + stepTracker.dailyStepsGoal);
                System.out.println("Введите новую цель: ");
                int newDailyStepsGoal = scanner.nextInt();
                while (newDailyStepsGoal < 0) {
                    System.out.println("Введите положительное число: ");
                    newDailyStepsGoal = scanner.nextInt();
                }
                stepTracker.setDailyStepsGoal(newDailyStepsGoal);
            } else {
                System.out.println("Извините, команды \"" + userInput + "\" не существует. Пожалуйста, выберите из предложенного.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }

        System.out.println("Программа завершена. До встречи ;)");
    }

    public static void printMenu() {
        System.out.println("Что хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выход.");
    }
}
