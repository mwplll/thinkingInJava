package concurrency;

//: concurrency/MutexEvenGenerator.java
//Preventing thread collisions with mutexes.
//{RunByHand}
import java.util.concurrent.locks.*;

public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	//Lock对象来自于java.util.concurrent.locks
	private Lock lock = new ReentrantLock();
	public int next() {
	//显示加锁
	 lock.lock();
	 try {
	   ++currentEvenValue;
	   Thread.yield(); // Cause failure faster
	   ++currentEvenValue;
	   //return必须在try中出现
	   return currentEvenValue;
	 } finally {
		 //显示释放
	   lock.unlock();
	 }
	}
	public static void main(String[] args) {
	 EvenChecker.test(new MutexEvenGenerator());
	}
} ///:~

