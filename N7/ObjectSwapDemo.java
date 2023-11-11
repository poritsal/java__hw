public class ObjectSwapDemo {
    public static void main(String[] args) {
        // Пример использования метода для обмена самими экземплярами
        Value obj1 = new Value(10);
        Value obj2 = new Value(20);

        System.out.println("Первый объект: " + obj1);
        System.out.println("Второй объект: " + obj2);

        // Обмен экземплярами
        Value[] swappedObjects = swapObjects(obj1, obj2);
        obj1 = swappedObjects[0];
        obj2 = swappedObjects[1];

        System.out.println("После обмена:");
        System.out.println("Первый объект: " + obj1);
        System.out.println("Второй объект: " + obj2);
    }

    // Метод для обмена экземплярами класса
    private static Value[] swapObjects(Value objA, Value objB) {
        Value temp = objA;
        objA = objB;
        objB = temp;

        return new Value[]{objA, objB};
    }
}

// Пример класса
class Value {
    private int value;

    public Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" + "value=" + value + '}';
    }
}
