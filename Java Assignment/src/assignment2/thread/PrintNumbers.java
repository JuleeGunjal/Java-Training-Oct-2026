package assignment2.thread;
//Write a program which will create two threads and print the 10 numbers in sequence.

public class PrintNumbers
{
    private int count = 1;
    public synchronized void printOddNumbers() {
        while(count < 10) {
            if (count % 2 == 0) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.print(count + " ");
            count++;
            notifyAll();
        }
    }

    public synchronized void printEvenNumbers() {
        while(count < 10) {
            if (count % 2 == 1) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.print(count + " ");
            count++;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintNumbers p = new PrintNumbers();
         Thread t1 = new Thread(p::printOddNumbers);
         Thread t2 = new Thread(p::printEvenNumbers);
         t1.start();
         t2.start();
    }
}
