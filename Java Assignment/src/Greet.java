import java.util.Scanner;

public class Greet {
    public void talk() {
        System.out.println("Hello");
    }
    public void talk(String name) {
        System.out.println("Hello " + name);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Greet g = new Greet();
        g.talk();
        g.talk("Hello");
        g.talk("World");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        g.talk(name);

    }
}

