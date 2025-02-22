package second;

public class TemplateClass <Type> {
    public Type value;

    public TemplateClass(Type value) {
        this.value = value;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TemplateClass{" +
                "value=" + value +
                '}';
    }
}
