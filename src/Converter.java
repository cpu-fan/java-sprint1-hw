public class Converter {
    int avgStep = 75;
    int avgCal = 50;

    // Конвертирование шагов в километры
    public double distanceInKm(int steps) {
        return (double) (steps * avgStep) / 100000;
    }

    // Конвертирование шагов в килокалории
    public double kCal(int steps) {
        return (double) (steps * avgCal) / 1000;
    }
}
