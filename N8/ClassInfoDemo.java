import java.lang.reflect.*;

public class ClassInfoDemo {

    public static void printClassInfo(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("Имя класса: " + clazz.getName());

        // Получение информации о полях
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("\nПоля:");
        for (Field field : fields) {
            System.out.println("  " + Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
        }

        // Получение информации о методах
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("\nМетоды:");
        for (Method method : methods) {
            System.out.print("  " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName() + "(");

            // Вывод параметров метода
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }

        // Получение информации о конструкторах
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("\nКонструкторы:");
        for (Constructor<?> constructor : constructors) {
            System.out.print("  " + Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + "(");

            // Вывод параметров конструктора
            Parameter[] parameters = constructor.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        // Пример использования метода
        printClassInfo(new SampleClass());
    }
}

class SampleClass {
    private int privateField;
    public String publicField;

    public SampleClass() {
    }

    public SampleClass(int privateField, String publicField) {
        this.privateField = privateField;
        this.publicField = publicField;
    }

    private void privateMethod() {
    }

    public void publicMethod(int parameter1, String parameter2) {
    }
}
