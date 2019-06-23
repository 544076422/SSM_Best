public class test2 {
    public static void main(String[] args) {
        Thread1 thread1  = new Thread1(true);
        Thread1 thread2  = new Thread1(false);
        thread2.start();
        thread1.start();
    }
}
