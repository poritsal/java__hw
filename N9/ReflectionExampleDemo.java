import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionExampleDemo {

    public static void main(String[] args) {
        try {
            // Имя класса
            String className = "SampleClass";

            // Имя метода
            String methodName = "printMessage";

            // Создание экземпляра класса
            Object instance = createInstance(className);

            // Вызов метода
            invokeMethod(instance, methodName);
            invokeMethod(instance, "setMessage", "Новое сообщение");
            invokeMethod(instance, "getMessage");
            
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static Object createInstance(String className) throws ClassNotFoundException {
        try {
            // Получение класса по имени
            Class<?> clazz = Class.forName(className);

            // Получение конструктора без параметров
            Constructor<?> constructor = clazz.getConstructor();

            // Создание экземпляра класса
            Object instance = constructor.newInstance();
            System.out.println("Создан экземпляр класса " + className);
            return instance;

        } catch (Exception e) {
            throw new ClassNotFoundException("Не удалось создать экземпляр класса " + className, e);
        }
    }

    public static void invokeMethod(Object instance, String methodName, Object... args) throws NoSuchMethodException {
        try {
            // Получение метода по имени
            Class<?>[] parameterTypes = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }

            Method method = instance.getClass().getMethod(methodName, parameterTypes);

            // Вызов метода на созданном экземпляре
            Object result = method.invoke(instance, args);
            if (result != null) {
                System.out.println("Результат выполнения метода: " + result);
            }

            System.out.println("Метод " + methodName + " выполнен");

        } catch (Exception e) {
            throw new NoSuchMethodException("Не удалось выполнить метод " + methodName);
        }
    }
}