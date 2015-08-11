package concurrency;

//: concurrency/SynchronizedEvenGenerator.java
//Simplifying mutexes with the synchronized keyword.
//{RunByHand}

public class
SynchronizedEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	//使用synchronized给方法加锁
	public synchronized int next() {
	 ++currentEvenValue;
	 Thread.yield(); // Cause failure faster
	 ++currentEvenValue;
	 return currentEvenValue;
	}
	public static void main(String[] args) {
	 EvenChecker.test(new SynchronizedEvenGenerator());
	}
} ///:~

