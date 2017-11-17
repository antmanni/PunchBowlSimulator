//Servant : fills the bowl when it becomes empty.

class Servant implements Runnable{
	private Thread t;
	private Bowl bowl;
	private String servant;
	
	public Servant(Bowl b, String s) {
		bowl = b;
		servant = s;
	}
	
	public void run() {
		while(true) {
			if (!bowl.isFilled()){
				bowl.fillBunch();		
			}
			else {
				try {
					Thread.sleep(2000);
				}
				catch(InterruptedException e) {
					
				}
			}
		}
	}
	
	public void start() {
		if (t == null) {
			t = new Thread (this, servant);
			t.start();
		}
	}
}
