public class Thread1 extends Thread {
    private Boolean flag;

    public Thread1(Boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        if (flag){
            synchronized (MyLock.m1){
                System.out.println("hehe");
                synchronized (MyLock.m2){
                    System.out.println("haha");
                }
            }
        }else {
            synchronized(MyLock.m2){
                System.out.println("1111111111");
                synchronized (MyLock.m1){
                    System.out.println("22222222222");
                }
            }
        }
    }
}
