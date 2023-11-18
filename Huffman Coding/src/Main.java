import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите режим:");
        System.out.println("1. Кодирование");
        System.out.println("2. Декодирование");
        System.out.println("3. Информирование");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Режим кодирования
                System.out.println("Введите имя входного файла:");
                String inputEncode = scanner.next();

                System.out.println("Введите имя выходного файла:");
                String outputEncode = scanner.next();

                huffmanCoding.encode(inputEncode, outputEncode);
                System.out.println("Файл успешно закодирован.");
                break;
            case 2:
                // Режим декодирования           
                System.out.println("Введите имя входного файла:");
                String inputDecode = scanner.next();

                System.out.println("Введите имя выходного файла:");
                String outputDecode = scanner.next();

                huffmanCoding.decode(inputDecode, outputDecode);
                System.out.println("Файл успешно декодирован.");
                break;
            case 3:
                // Режим информирования
                System.out.println("Введите имя входного файла:");
                String infoFileName = scanner.next();
                huffmanCoding.info(infoFileName);
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите от 1 до 3.");
                break;
        }
        scanner.close();
    }
}
