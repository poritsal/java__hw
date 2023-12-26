import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Huffman huffman = new Huffman();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите режим:");
        System.out.println("1. Кодирование");
        System.out.println("2. Декодирование");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Режим кодирования
                System.out.println("Введите имя входного файла:");
                String inputEncode = scanner.next();

                System.out.println("Введите имя выходного файла:");
                String outputEncode = scanner.next();
                
                huffman.encode(inputEncode, outputEncode);
                System.out.println("Файл успешно закодирован.");
                break;
            case 2:
                // Режим декодирования           
                System.out.println("Введите имя входного файла:");
                String inputDecode = scanner.next();

                System.out.println("Введите имя выходного файла:");
                String outputDecode = scanner.next();
                
                huffman.decode(inputDecode, outputDecode);
                System.out.println("Файл успешно декодирован.");
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите от 1 или 2.");
                break;
        }
        scanner.close();
    }
}

