
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
	
		int i=1;
		while(i<=10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i: "+i);
			i=i+1;
		}

	}

}
