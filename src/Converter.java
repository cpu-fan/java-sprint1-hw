public class Converter {
    int avgStep; // размер среднего шага в сантиметрах
    int avgCal; // количество сожженных калорий за 1 шаг

    public Converter() {
        avgStep = 75; // принимаем значение по умолчанию 75
        avgCal = 50; // принимаем значение по умолчанию 50
    }

    // Конвертирование шагов в километры
    public double distanceInKm(int steps) {
        return (double) (steps * avgStep) / 100000;
    }

    // Конвертирование шагов в килокалории
    public double kCal(int steps) {
        return (double) (steps * avgCal) / 1000;
    }
}
