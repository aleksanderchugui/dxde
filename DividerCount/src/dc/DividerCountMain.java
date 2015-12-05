package dc;

import java.util.ArrayList;
import java.util.concurrent.*;

public class DividerCountMain {
	public static void main(String[] args) throws ExecutionException {
		long[] givenLong = { 253L, 1_548_256_147L, 1325L, 85_652_012L, 4_255_458_111L, 585_586L, 956L, 985_456_730L,
				23_125L, 321_178_045L };
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new DividerCount(givenLong[i])));
		}
		
		for (Future<String> fs : results) {
			
			try {
				if(fs.isDone()) {
					System.out.println(fs.get());
				}
					continue;
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} 
		}
		exec.shutdown();
	}
}

class DividerCount implements Callable<String> {
	private long l;
	private int count;
	
	public DividerCount(long l) {
		this.l = l;
		this.count = 0;
	}
	
	public String call() {
		for ( long i = 2; i < this.l; i++) {
		      if (this.l % i == 0) {
		    	  count++;
		      }
		  }
		return "Для числа " + this.l + " количество делителей: " + count;
	}
}