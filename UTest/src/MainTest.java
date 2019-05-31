public class MainTest {
    public static void main(String []args){
    testFinalIncrement();
    }
    private static void testFinalIncrement(){
        SharedCounter sc = new SharedCounter();
        Thread t1 = new Thread(sc,"first thread");
        Thread t2 = new Thread(sc,"second thread");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert sc.getCounter() == 200 : "true";
        assert t1.isAlive() == false : "true";
        assert t2.isAlive() == false : "true";


    }
}
