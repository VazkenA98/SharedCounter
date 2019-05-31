public class SharedCounter extends Thread{
    static int counter = 0;

    public SharedCounter(){

    }


    public synchronized void increment() {
        for (int i=0;i<100;i++){
            counter++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+counter+" "+i);
        }

    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        increment();
    }
}
