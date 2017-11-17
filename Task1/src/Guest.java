//Guest waits in queue and takes a portion from the bowl when bowl's queueIndex matches the guest's ID
//variables :
//questID : if the quests' ID is same as the queueIndex, drink from the bowl
//bowl : Bowl


class Guest implements Runnable{
	private Thread t;
	private int questID;
	private Bowl bowl;
	private String guest;
	
	public Guest(int ID, Bowl b, String g) {
		questID = ID;
		bowl = b;
		guest = g;
	}
	
	public void run() {
		while(true) {
			if (bowl.isFilled() && bowl.hasTurn(questID)) {
				bowl.takeBunch(questID);
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
			t = new Thread (this, guest);
			t.start();
		}
	}
	
}
