public class StepTracker {
    Converter converter;
    int dailyStepsGoal;
    MonthData[] monthToData;

    public StepTracker(Converter converter) {
        this.converter = converter;
        this.dailyStepsGoal = 10000;
        this.monthToData = new MonthData[12];
        for (int i = 0; i < this.monthToData.length; i++) {
            this.monthToData[i] = new MonthData();
        }
    }

    // Запись шагов за определенную дату
    public void setStepsForDate(int month, int day, int steps) {
        monthToData[month].days[day] = steps;
    }

    // Вывод общей статистики за месяц
    public void displayMonthlyStatistics(int month) {
        System.out.println("\nКоличество пройденных шагов по дням:");
        monthToData[month].stepsPerDay(month);
        System.out.println("Общее количество шагов за месяц: " + monthToData[month].totalStepsPerMonth(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthToData[month].maxStepsPerMonth(month));
        System.out.println("Среднее количество шагов: " + monthToData[month].totalStepsPerMonth(month) / monthToData[month].days.length);
        System.out.println("Пройденная дистанция (в км): " + String.format("%.2f", converter.distanceInKm(monthToData[month].totalStepsPerMonth(month))));
        System.out.println("Количество сожжённых килокалорий: " + String.format("%.2f", converter.kCal(monthToData[month].totalStepsPerMonth(month))));
        System.out.println("Лучшая серия: " + monthToData[month].theBestSeries(month));
    }

    // Изменение цели по количеству шагов в день
    public void setDailyStepsGoal(int newDailyStepGoal) {
        dailyStepsGoal = newDailyStepGoal;
    }

    class MonthData {
        int[] days;
        public MonthData() {
            days = new int[30];
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
            for (int j : bestSeriesArr) {
                if (j > bestSeries) {
                    bestSeries = j;
                }
            }
            return bestSeries;
        }
    }
}
