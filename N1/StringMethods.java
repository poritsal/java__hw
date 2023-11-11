public class StringMethods {
    public static void main(String[] args) {
        // Пример строки
        String originalString = "Hello, World!";

        // Получение длины строки
        int length = originalString.length();
        System.out.println("1. Длина строки: " + length);

        // Получение символа по индексу
        char charAtIndex = originalString.charAt(7);
        System.out.println("2. Символ по индексу 7: " + charAtIndex);

        // Получение подстроки
        String substring = originalString.substring(7, 12);
        System.out.println("3. Подстрока с 7 по 11 индексы: " + substring);

        // Проверка начала строки
        boolean startsWith = originalString.startsWith("Hello");
        System.out.println("4. Начинается ли строка с 'Hello': " + startsWith);

        // Проверка окончания строки
        boolean endsWith = originalString.endsWith("World!");
        System.out.println("5. Заканчивается ли строка на 'World!': " + endsWith);

        // Поиск индекса первого вхождения подстроки
        int indexOf = originalString.indexOf("World");
        System.out.println("6. Индекс первого вхождения 'World': " + indexOf);

        // Преобразование в верхний регистр
        String upperCase = originalString.toUpperCase();
        System.out.println("7. Строка в верхнем регистре: " + upperCase);

        // Преобразование в нижний регистр
        String lowerCase = originalString.toLowerCase();
        System.out.println("8. Строка в нижнем регистре: " + lowerCase);

        // Конкатенация строк
        String concatenated = originalString + " Java!";
        System.out.println("9. Конкатенация строк: " + concatenated);

        // Замена символов
        String replacedString = originalString.replace('o', '0');
        System.out.println("10. Замена 'o' на '0': " + replacedString);

        // Использование StringBuilder для эффективной конкатенации
        StringBuilder stringBuilder = new StringBuilder(originalString);
        stringBuilder.append(" Java!");
        System.out.println("11. Конкатенация с использованием StringBuilder: " + stringBuilder.toString());

        double temperature = 80.0;

        // Преобразование числа в строку
        String temperatureString = Double.toString(temperature);
        System.out.println("12. Преобразование числа в строку: " + temperatureString);

        // Конкатенация строк
        String message = "Текущая температура: " + temperatureString + " градусов";
        System.out.println("13. Конкатенация строк: " + message);

        // Поиск индекса символа
        int index = message.indexOf(':');
        System.out.println("14. Индекс символа ':': " + index);

        // Проверка наличия подстроки
        boolean containsSubstring = message.contains("Температура");
        System.out.println("15. Проверка наличия подстроки 'Температура': " + containsSubstring);
    }
}
