package tips.lang;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ExRunnable r1 = new ExRunnable(4);
        System.out.println(Thread.currentThread().toString() + ", " + r1.integerThreadLocal.get());

        Thread th1 = new Thread(r1);

        th1.start();
    }
}

class ExRunnable implements Runnable{
    ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    ExRunnable(int n){
        integerThreadLocal.set(n);
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().toString() + ", " + integerThreadLocal.get());
    }
}
