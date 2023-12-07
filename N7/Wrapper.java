public class Wrapper<ObjectType> {
    private ObjectType data;

    public Wrapper(ObjectType data) {
        this.data = data;
    }

    public void swap(Wrapper<ObjectType> swapObject) {
        SwapObjects(this, swapObject);
    }

    public static <T> void SwapObjects(Wrapper<T> firstObject, Wrapper<T> secondObject) {
        if (firstObject.getData().getClass() == secondObject.getData().getClass()) {
            T dataSaveObject = secondObject.data;
            secondObject.data = firstObject.data;
            firstObject.data = dataSaveObject;
        }
    }

    public ObjectType getData() {
        return data;
    }

    public void setData(ObjectType data) {
        this.data = data;
    }
}