public class SampleClass {
    private String message;

    public SampleClass() {
        this.message = "Default message";
    }

    public SampleClass(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Привет, это метод printMessage! Сообщение: " + message);
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Сообщение установлено: " + message);
    }

    public String getMessage() {
        return message;
    }
}
