package concurrency;
import java.util.concurrent.*;

public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;
	//构造方法
	public EvenChecker(IntGenerator g, int ident) {
	  generator = g;
	  id = ident;
	}
	
	public void run() {
	  while(!generator.isCanceled()) {
	    int val = generator.next();
	    if(val % 2 != 0) {
	      System.out.println(val + " not even!");
	      //将使所有其他使用该IntGenerater的EvenChecker关闭
	      generator.cancel(); // Cancels all EvenCheckers
	    }
	  }
	}
	// Test any type of IntGenerator:
	public static void test(IntGenerator gp, int count) {
	  System.out.println("Press Control-C to exit");
	  ExecutorService exec = Executors.newCachedThreadPool();
	  for(int i = 0; i < count; i++)
	    exec.execute(new EvenChecker(gp, i));
	  exec.shutdown();
	}
	// Default value for count:
	public static void test(IntGenerator gp) {
	  test(gp, 10);
	}
} ///:~

