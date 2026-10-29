package assignment2.thread;

/*Write a program with Sender class which has a send method that prints a message passed as a parameter.
Then create a class ThreadedSend which extends Thread class and in constructor it accepts as message and Sender object.
Now write a demo class which will create two threads using the ThreadedSend class.
One thread will take the message as “Hi” and another thread will take message input as “Bye”.
Now write a function which will print  “Hi” 1st and then “Bye”.
 */


class Sender {
    public void send(String message) {
        System.out.println(message);
    }
}

class ThreadedSend extends Thread
{
    public ThreadedSend() {

    }
    public ThreadedSend(String message, Sender sender) {
        sender.send(message);
    }
}

class Demo
{
    public static void main(String[] args) {
        Sender sender = new Sender();
        ThreadedSend ts1 = new ThreadedSend("Hi", sender);
        ThreadedSend ts2 = new ThreadedSend("Bye", sender);
        ts1.start();
        ts2.start();


    }
}