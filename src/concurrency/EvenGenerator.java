package concurrency;

//: concurrency/EvenGenerator.java
//When threads collide.

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	public int next() {
	 //一个任务有可能在另一个任务执行第一个currentEvenValue的递增操作时，调用next()方法
	 ++currentEvenValue; // Danger point here!
	 ++currentEvenValue;
	 return currentEvenValue;
	}
	public static void main(String[] args) {
	 EvenChecker.test(new EvenGenerator());
	}
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~

