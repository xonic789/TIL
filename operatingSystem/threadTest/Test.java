package operatingSystem.threadTest;

public class Test {
	public static void main(String[] args) {
		MyThread th = new MyThread();
		th.start();
		while (true) {
			System.out.print("A");
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {}

		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.print("B");
			try {
				sleep(100);
			} catch(InterruptedException e) {}

		}
	}
}
