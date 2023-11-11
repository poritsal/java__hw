public class CommandLineArgumentsDemo {

    public static void main(String[] args) {
        // Проверка наличия аргументов
        if (args.length == 0) {
            System.out.println("Нет аргументов командной строки.");
        } else {
            System.out.println("Аргументы командной строки:");

            // Вывод каждого аргумента на экран
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
            }
        }
    }
}
