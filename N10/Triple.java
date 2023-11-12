public class Triple<T extends Comparable<T>> {
    private T first;
    private T second;
    private T third;

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    public T min() {
        return min(first, min(second, third));
    }

    public T max() {
        return max(first, max(second, third));
    }

    public T mean() {
    // Сравниваем элементы тройки
    int comparisonLeftMiddle = first.compareTo(second);
    int comparisonMiddleRight = second.compareTo(third);
    int comparisonLeftRight = first.compareTo(third);

    // Проверяем, равны ли два элемента из тройки
    boolean isEqualLeftMiddle = comparisonLeftMiddle == 0;
    boolean isEqualMiddleRight = comparisonMiddleRight == 0;
    boolean isEqualLeftRight = comparisonLeftRight == 0;

    // Проверяем равенство всех трех элементов
    if (isEqualLeftMiddle && isEqualMiddleRight) {
        // Все три элемента равны
        return first;
    }

    // Проверяем равенство двух элементов
    if (isEqualLeftMiddle) {
        return min(first, second);
    } else if (isEqualMiddleRight) {
        return min(first, third);
    } else if (isEqualLeftRight) {
        return min(first, second);
    }

    // Если ни один из элементов не равен другому, находим средний элемент
    return min(max(first, second), min(max(first, third), max(second, third)));
}

    private T min(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    private T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static void main(String[] args) {
        Triple<String> triple1 = new Triple<>("af", "fd", "gdh");

        System.out.println("First: " + triple1.getFirst());
        System.out.println("Second: " + triple1.getSecond());
        System.out.println("Third: " + triple1.getThird());
        System.out.println("Min: " + triple1.min());
        System.out.println("Max: " + triple1.max());
        System.out.println("Mean: " + triple1.mean());

        Triple<Integer> triple2 = new Triple<>(5, 6, 7);

        System.out.println("First: " + triple2.getFirst());
        System.out.println("Second: " + triple2.getSecond());
        System.out.println("Third: " + triple2.getThird());
        System.out.println("Min: " + triple2.min());
        System.out.println("Max: " + triple2.max());
        System.out.println("Mean: " + triple2.mean());
    }
}