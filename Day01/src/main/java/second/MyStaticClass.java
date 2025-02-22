package second;

public abstract class MyStaticClass {
    public static void Method1(String[] args) {
        BaseClass baseClass = new BaseClass();
        BaseClass baseClass2 = new BaseClass(1);

        BaseClass baseClass3 = new BaseClass(1, 2);
    }
}
