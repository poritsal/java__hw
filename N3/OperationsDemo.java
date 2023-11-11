import java.util.Scanner;

public class OperationsDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Креативный Калькулятор!");

        // Логические операции && || !
        System.out.println("=== Логические операции && || !");
        System.out.print("Введите число x: ");
        int x = scanner.nextInt();
        System.out.print("Введите число y: ");
        int y = scanner.nextInt();

        boolean logicalAnd = x > 0 && y > 0;
        boolean logicalOr = x > 0 || y > 0;
        boolean logicalNotX = !(x > 0);
        boolean logicalNotY = !(y > 0);

        System.out.println("x > 0 && y > 0: " + logicalAnd);
        System.out.println("x > 0 || y > 0: " + logicalOr);
        System.out.println("!(x > 0): " + logicalNotX);
        System.out.println("!(y > 0): " + logicalNotY);

        // Тернарная операция x < y ? x : y
        System.out.println("\n=== Тернарная операция x < y ? x : y");
        int min = x < y ? x : y;
        System.out.println("Минимальное из чисел x и y: " + min);

        // Поразрядные логические операции & | ^ ~
        System.out.println("\n=== Поразрядные логические операции & | ^ ~");
        int bitwiseAnd = x & y;
        int bitwiseOr = x | y;
        int bitwiseXor = x ^ y;
        int bitwiseNotX = ~x;

        System.out.println("Поразрядное И x & y: " + bitwiseAnd);
        System.out.println("Поразрядное ИЛИ x | y: " + bitwiseOr);
        System.out.println("Поразрядное исключающее ИЛИ x ^ y: " + bitwiseXor);
        System.out.println("Поразрядное НЕ ~x: " + bitwiseNotX);

        // Операции сдвига >> << >>>
        System.out.println("\n=== Операции сдвига >> << >>>");
        System.out.print("Введите число для сдвига: ");
        int shiftNumber = scanner.nextInt();

        int rightShift = x >> shiftNumber;
        int leftShift = x << shiftNumber;
        int unsignedRightShift = x >>> shiftNumber;

        System.out.println("Сдвиг вправо x >> " + shiftNumber + ": " + rightShift);
        System.out.println("Сдвиг влево x << " + shiftNumber + ": " + leftShift);
        System.out.println("Беззнаковый сдвиг вправо x >>> " + shiftNumber + ": " + unsignedRightShift);

        scanner.close();
    }
}
