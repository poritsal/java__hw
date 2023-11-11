import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// чтение данных с консоли
public class LScanner {
    public static void main(String[] args) {
        // Ввод-вывод из файла
        String dir = System.getProperty("user.dir"); // каталог запуска
        System.out.println(dir);

        try {
            Scanner fin = new Scanner(Paths.get(dir, "input.txt"), "UTF-8");
            while (fin.hasNext()) {
                String word = fin.next();
                System.out.println(word);
            }
        } catch (NoSuchFileException e) {
            System.out.println("Exception 1: " + e);
        } catch (IOException e) {
            System.out.println("Exception 2: " + e);
        } catch (Exception e) {
            System.out.println("Exception 3: " + e);
        }
    }
}
