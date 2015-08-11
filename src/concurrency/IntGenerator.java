package concurrency;

public abstract class IntGenerator {
	//canceled定义为volatile变量，保证线程可见性
	private volatile boolean canceled = false;
	public abstract int next();
	// Allow this to be canceled:
	public void cancel() { canceled = true; }
	public boolean isCanceled() { return canceled; }
} ///:~
