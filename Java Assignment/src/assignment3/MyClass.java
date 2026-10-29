package assignment3;

public class MyClass
{
    static int a = 20;
    static {
        System.out.println("Static initialization");
        a++;
    }
    {
        System.out.println("instance initialization");
        a++;
        System.out.println(a);
    }
    public static void main(String[] args)
    {
        MyClass obj = new MyClass();
        MyClass obj2 = new MyClass();
        MyClass obj3 = new MyClass();
    }
}
