package second;

import lombok.Data;


public class BaseClass {

    {
        System.out.println("BaseClass instance initializer");
        a = 10;
        b = 20;
        c = 30;
    }

    public BaseClass() {
        System.out.println("BaseClass constructor");
    }

    public BaseClass(int a) {
        //this();
        this.a = a;
        System.out.println("BaseClass constructor with a");
    }
    public BaseClass(int a, int b) {
        //this(a);
        this.b = b;
        System.out.println("BaseClass constructor with a and b");
    }

    public void method1() {
        System.out.println("BaseClass method1");
    }

    @Override
    public String toString() {
        return  this.getClass() + "{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public int a;
    private int b;
    protected int c;

}
