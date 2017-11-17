import java.util.Arrays;
import java.util.Random;

//Class for the bowl. Guest threads use this take drink from the bowl. Servant thread fills the bowl when empty
//variables :
//portions: the amount of portions in the bowl. True means there is still bowl left in the element, false mean that portion has been drunk
//takingTime: the amount of time it takes to take and drink the portion.
//queueIndex: determines whose turn it is to take a portion
//maxIndex: last Index of the guest array. queueIndex should never get bigger than this


public class Bowl extends Task1Locks{
	    private boolean[] portions;
	    private int takingTime, queueIndex, maxIndex;
	    private Random rand;
	    
	    public Bowl(int p, int t, int i){
	    	super();
	        portions = new boolean[p];
	        takingTime = t;
	        maxIndex = i;
	        queueIndex = 0;
	        fillBunch();
	        rand = new Random();
	    }
	            
	 
	    //Checks what portions are taken and then, if there are portions left,
	    //"hands" one to guest and changes the element to false.
	    protected void takeBunch(int questID) {

	    	
	    	for (int n = portions.length-1 ; n >= 0; n--)
	    	{
	    		if (portions[n])
	    		{
	    			try {
	    			portions[n] = false;
	    			System.out.println("Guest number " + questID + " Is taking a portion number " + (n+1));
            		Thread.sleep(rand.nextInt(takingTime)*1000);
            		increaseIndex();
	    			break;
	    			}
	    			catch(InterruptedException e) {
	    				e.printStackTrace();
	    			}
	    		}

	    	}

	    }

	    
	    //fills the bowl
	    protected void fillBunch() {
	        Arrays.fill(portions, true);
	        System.out.println("The bowl has been filled");
	    }

	    
	    //Checks if there are portions left in the bowl
	    protected boolean isFilled() {
	    	
	    	for (boolean n : portions)
	    	{

	    		if (n == true) 
	    		{
	    			return n;
	    		}
	    	}
	    	
	    	return false;
	    }

	    //Increments the index. If Index is bigger than the length of the guest arrays, start from zero.
	    protected void increaseIndex() {
	    
	    	queueIndex++;
	    	if (queueIndex > maxIndex) {
	    		queueIndex = 0;
	    	}
	    }
	    
	    //Determines whose turn it is to take a portion from bowl
	    protected boolean hasTurn(int ID){{
	    	return ((ID -1) == queueIndex);
	    }


	}
}