import java.util.Scanner;

public class SwitchDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип данных для switch:");
        System.out.println("1. Целые числа");
        System.out.println("2. Символы");
        System.out.println("3. Строки");
        System.out.println("4. Перечисления");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Целые числа
                System.out.print("Введите целое число: ");
                int intValue = scanner.nextInt();
                switchInt(intValue);
                break;

            case 2:
                // Символы
                System.out.print("Введите символ: ");
                char charValue = scanner.next().charAt(0);
                switchChar(charValue);
                break;

            case 3:
                // Строки
                System.out.print("Введите строку: ");
                String stringValue = scanner.next();
                switchString(stringValue);
                break;

            case 4:
                // Перечисления
                System.out.println("Выберите цвет (RED, GREEN, BLUE): ");
                String colorString = scanner.next();
                switchEnum(Color.valueOf(colorString.toUpperCase()));
                break;

            default:
                System.out.println("Некорректный выбор.");
        }

        scanner.close();
    }

    private static void switchInt(int value) {
        switch (value) {
            case 1:
                System.out.println("Вы ввели число 1.");
                break;
            case 2:
                System.out.println("Вы ввели число 2.");
                break;
            default:
                System.out.println("Другое число.");
        }
    }

    private static void switchChar(char value) {
        switch (value) {
            case 'A':
                System.out.println("Вы ввели символ 'A'.");
                break;
            case 'B':
                System.out.println("Вы ввели символ 'B'.");
                break;
            default:
                System.out.println("Другой символ.");
        }
    }

    private static void switchString(String value) {
        switch (value.toLowerCase()) {
            case "apple":
                System.out.println("Вы ввели 'apple'.");
                break;
            case "banana":
                System.out.println("Вы ввели 'banana'.");
                break;
            default:
                System.out.println("Другая строка.");
        }
    }

    private static void switchEnum(Color color) {
        switch (color) {
            case RED:
                System.out.println("Вы выбрали красный цвет.");
                break;
            case GREEN:
                System.out.println("Вы выбрали зеленый цвет.");
                break;
            case BLUE:
                System.out.println("Вы выбрали синий цвет.");
                break;
            default:
                System.out.println("Другой цвет.");
        }
    }

    // Пример перечисления
    private enum Color {
        RED, GREEN, BLUE
    }
}
