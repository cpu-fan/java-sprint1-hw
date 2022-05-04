public class Converter {
    static int avgStep = 75; // размер среднего шага в сантиметрах (по умолчанию)
    static int avgCal = 50; // среднее количество калорий сжигаемых при совершении одного шага (по умолчанию)

    // нужен ли здесь конструктор?

    // Метод для конвертирования шагов в километры
    public static double distanceInKm(int steps) {
        return (steps * avgStep) / 100000;
    }

    // Метод для конвертирования шагов в килокалории
    public static double kCal(int steps) {
        return (steps * avgCal) / 1000;
    }
}
