package tr;

public class ThreadsMain {
	public static void main(String[] args) {
		Thread threadImplements = new Thread(new ThreadImplements());
		ThreadExtends threadExtends = new ThreadExtends();

		threadImplements.start();
		threadExtends.start();
		System.out.println("ThreadExtends ");
	}
}

class ThreadImplements implements Runnable {

	ThreadImplements() {
	}

	public void run() {
		int num = 0;

		while (num < 10) {
			System.out.println("ThreadImplements " + num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num++;
		}
	}
}

class ThreadExtends extends Thread {

	ThreadExtends() {
	}

	public void run() {
		int num = 0;

		while (num < 10) {
			System.out.println("ThreadExtends " + num);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num++;
		}
	}
}
