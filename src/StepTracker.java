public class StepTracker {
    int dailyStepsGoal = 10000;

    void setDailyStepsGoal(int num) {
        dailyStepsGoal = num;
        System.out.println("Цель по количеству шагов в день: " + dailyStepsGoal);
    }
}
