
public class Main1 {

	public static void main(String[] args) {
		/*
		 * RunnableImpl r= new RunnableImpl(); Thread th=new Thread(r); th.start();
		 * 
		 * RunnableImpl r1= new RunnableImpl(); Thread th1=new Thread(r1); th1.start();
		 */

		Runnable r = ()-> {
				int i = 1;
				while (i <= 10) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("i: " + i);
					i = i + 1;
				}
		};
		Thread th = new Thread(r);
		th.start();

	}

}
